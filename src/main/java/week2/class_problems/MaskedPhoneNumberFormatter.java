package week2.class_problems;

public class MaskedPhoneNumberFormatter {

    static void formatPhoneNumber(String phoneNumber) {

        // Validate length
        if (phoneNumber.length() != 10) {
            System.out.println("Invalid Phone Number");
            return;
        }

        // Validate that all characters are digits
        for (int i = 0; i < phoneNumber.length(); i++) {

            if (!Character.isDigit(phoneNumber.charAt(i))) {
                System.out.println("Invalid Phone Number");
                return;
            }
        }

        // Build masked number
        StringBuilder maskedNumber = new StringBuilder();

        maskedNumber.append("XXXXXX");
        maskedNumber.append("-");
        maskedNumber.append(phoneNumber.substring(6));

        System.out.println("Masked Number: " + maskedNumber);
    }

    public static void main(String[] args) {

        String phoneNumber = "9876543210";

        formatPhoneNumber(phoneNumber);
    }
}
