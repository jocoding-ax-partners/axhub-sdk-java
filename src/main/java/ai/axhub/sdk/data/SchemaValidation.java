package ai.axhub.sdk.data;

import ai.axhub.sdk.data.Schema.DataTableSchema;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * Optional schema validation hook (mirrors node dsl/zod.ts and the Python
 * port's dsl/validation.py).
 *
 * <p>The SDK duck-types a Pydantic/zod-style validator so the validation
 * library stays an optional dependency and is never imported. A validator is
 * "schema-like" if it exposes a callable {@code safeParse} (or
 * {@code safe_parse}). On {@code update} a {@code partial()} variant is used
 * when available.
 */
public final class SchemaValidation {
  private SchemaValidation() {}

  public static boolean isValidatorLike(Object value) {
    return value != null && (hasMethod(value, "safeParse", 1) || hasMethod(value, "safe_parse", 1));
  }

  /**
   * Validate {@code data} against {@code schema.validate()} before any network
   * request. {@code mode} is "insert" or "update" (update uses {@code partial()}
   * when available).
   */
  public static void runSchemaValidation(DataTableSchema schema, Object data, String mode) {
    Object validator = schema == null ? null : schema.validate();
    if (validator == null) return;
    if (!isValidatorLike(validator)) {
      throw new DataErrors.ConfigurationError(
          "defineSchema validate option requires a schema-like object with safeParse()",
          "validator_missing");
    }
    Object effective = validator;
    if ("update".equals(mode) && hasMethod(validator, "partial", 0)) {
      effective = invoke(validator, "partial");
    }
    Object result = invokeSafeParse(effective, data);
    if (isSuccess(result)) return;
    int count = Math.max(1, issueCount(result));
    throw new DataErrors.ValidationError(
        count + " validation failure" + (count == 1 ? "" : "s") + " before network request",
        "validation_failed");
  }

  private static boolean isSuccess(Object result) {
    Object success = readProperty(result, "success");
    return Boolean.TRUE.equals(success);
  }

  @SuppressWarnings("unchecked")
  private static int issueCount(Object result) {
    Object error = readProperty(result, "error");
    if (error == null) return 0;
    Object issues = readProperty(error, "issues");
    if (issues instanceof List<?> list) return list.size();
    return 0;
  }

  /** Read a field by getter, map key, or public field (handles record/POJO/Map validators). */
  private static Object readProperty(Object obj, String name) {
    if (obj == null) return null;
    if (obj instanceof Map<?, ?> map) return map.get(name);
    Object byMethod = tryInvoke(obj, name);
    if (byMethod != NO_RESULT) return byMethod;
    try {
      var field = obj.getClass().getField(name);
      return field.get(obj);
    } catch (ReflectiveOperationException ignored) {
      return null;
    }
  }

  private static Object invokeSafeParse(Object validator, Object data) {
    Method m = findMethod(validator, "safeParse", 1);
    if (m == null) m = findMethod(validator, "safe_parse", 1);
    try {
      m.setAccessible(true);
      return m.invoke(validator, data);
    } catch (ReflectiveOperationException e) {
      throw new DataErrors.ConfigurationError("validator safeParse threw: " + e.getMessage(), "validator_missing");
    }
  }

  private static Object invoke(Object target, String name) {
    Method m = findMethod(target, name, 0);
    try {
      m.setAccessible(true);
      return m.invoke(target);
    } catch (ReflectiveOperationException e) {
      throw new DataErrors.ConfigurationError("validator " + name + "() threw: " + e.getMessage(), "validator_missing");
    }
  }

  private static final Object NO_RESULT = new Object();

  private static Object tryInvoke(Object target, String name) {
    Method m = findMethod(target, name, 0);
    if (m == null) return NO_RESULT;
    try {
      m.setAccessible(true);
      return m.invoke(target);
    } catch (ReflectiveOperationException e) {
      return NO_RESULT;
    }
  }

  private static boolean hasMethod(Object target, String name, int argCount) {
    return findMethod(target, name, argCount) != null;
  }

  private static Method findMethod(Object target, String name, int argCount) {
    for (Method m : target.getClass().getMethods()) {
      if (m.getName().equals(name) && m.getParameterCount() == argCount) return m;
    }
    return null;
  }
}
