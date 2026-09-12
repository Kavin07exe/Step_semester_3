package week2.class_problems;

public class BankTransactionReferenceValidator {

    static String normalizeReference(String raw) {

        String reference = raw.trim();

        if (reference.length() < 3) {
            return reference;
        }

        String bankCode = reference.substring(0, 3).toUpperCase();
        String remaining = reference.substring(3);

        return bankCode + remaining;
    }

    static String validateAndFormat(String reference) {

        // Check length
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Check remaining 11 characters are digits
        for (int i = 3; i < reference.length(); i++) {

            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        // Extract date and sequence number
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String sequence = reference.substring(9, 14);

        StringBuilder result = new StringBuilder();

        result.append("[");
        result.append(reference.substring(0, 3));
        result.append("] DATE: ");
        result.append(day);
        result.append("/");
        result.append(month);
        result.append("/");
        result.append(year);
        result.append(" | SEQ: ");
        result.append(sequence);

        return result.toString();
    }

    public static void main(String[] args) {

        String rawReference = " hdf03022600042 ";

        String normalized = normalizeReference(rawReference);

        System.out.println(validateAndFormat(normalized));
    }
}