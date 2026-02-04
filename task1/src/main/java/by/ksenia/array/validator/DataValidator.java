package by.ksenia.array.validator;

public class DataValidator {
    private static final String VALID_REGEX = "^[\\d\\s,\\-;]+$";
    private static final String NUMBER_REGEX = "-?\\d+";

    public static boolean isValidString(String line) {
        if (line == null || line.trim().isEmpty()) {
            return false;
        }
        return line.matches(VALID_REGEX);
    }

    public static boolean isNumber(String str) {
        return str.matches(NUMBER_REGEX);
    }
}
