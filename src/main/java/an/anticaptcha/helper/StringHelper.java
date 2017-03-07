package an.anticaptcha.helper;


public class StringHelper {
    public static String toCamelCase(String s) {
        String[] parts = s.split("_");
        String camelCaseString = "";

        for (String part : parts) {
            camelCaseString += part.substring(0, 1).toUpperCase() + part.substring(1).toLowerCase();
        }

        return camelCaseString.substring(0, 1).toLowerCase() + camelCaseString.substring(1);
    }
}
