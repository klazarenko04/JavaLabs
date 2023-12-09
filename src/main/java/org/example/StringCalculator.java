package org.example;

public class StringCalculator {

    public int add(String numbers) {
        // Check if the input string is empty
        if (numbers.isEmpty()) {
            return 0;
        }

        // Check for user-defined delimiter
        String delimiter = ",";
        if (numbers.startsWith("//")) {
            // Extract custom delimiter
            int delimiterEnd = numbers.indexOf("\n");
            if (delimiterEnd != -1) {
                delimiter = numbers.substring(2, delimiterEnd);
                // Update numbers string to exclude the delimiter definition
                numbers = numbers.substring(delimiterEnd + 1);
            }
        }

        // Split the input string by the delimiter, commas, and newline characters
        String[] numArray = numbers.split("[,\n" + delimiter + "]");

        // Initialize sum to 0
        int sum = 0;

        // Iterate through the numbers and add them to the sum
        for (String num : numArray) {
            // Check for consecutive delimiters or empty values
            if (num.isEmpty()) {
                throw new IllegalArgumentException("Input contains consecutive delimiters or empty values");
            }

            // Convert each number to an integer
            int n = Integer.parseInt(num);
            // Add the number to the sum
            sum += n;
        }

        // Return the sum
        return sum;
    }

    public static void main(String[] args) {
        // Example usage
        StringCalculator calculator = new StringCalculator();

        try {
            System.out.println(calculator.add(""));
            System.out.println(calculator.add("1"));
            System.out.println(calculator.add("1,2"));
            System.out.println(calculator.add("1,2,3"));
            System.out.println(calculator.add("1\n2,3"));
            System.out.println(calculator.add("//;\n1;2,3\n2"));


        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}