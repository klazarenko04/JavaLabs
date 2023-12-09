package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                String delimiterPrefix = numbers.substring(2, delimiterEnd);
                // Check for arbitrary length delimiter enclosed in square brackets
                if (delimiterPrefix.startsWith("[") && delimiterPrefix.endsWith("]")) {
                    delimiter = delimiterPrefix.substring(1, delimiterPrefix.length() - 1);
                } else {
                    delimiter = delimiterPrefix;
                }
                // Update numbers string to exclude the delimiter definition
                numbers = numbers.substring(delimiterEnd + 1);
            }
        }

        // Split the input string by the delimiter
        String[] numArray = numbers.split("\\Q" + delimiter + "\\E|,|\n");

        // Initialize sum to 0
        int sum = 0;

        // List to store negative numbers
        List<Integer> negativeNumbers = new ArrayList<>();

        // Iterate through the numbers and add them to the sum
        for (String num : numArray) {
            // Check for consecutive delimiters or empty values
            if (num.isEmpty()) {
                throw new IllegalArgumentException("Input contains consecutive delimiters or empty values");
            }

            // Convert each number to an integer
            int n = Integer.parseInt(num);

            // Check for negative numbers
            if (n < 0) {
                negativeNumbers.add(n);
            }

            // Ignore numbers greater than 1000
            if (n <= 1000) {
                // Add the number to the sum
                sum += n;
            }
        }

        // If there are negative numbers, throw an exception with the list of negative numbers
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negativeNumbers);
        }

        // Return the sum
        return sum;
    }

    public static void main(String[] args) {
        // Example usage
        StringCalculator calculator = new StringCalculator();

        try {
            System.out.println(calculator.add(""));      // Output: 0
            System.out.println(calculator.add("1"));     // Output: 1
            System.out.println(calculator.add("1,2"));   // Output: 3
            System.out.println(calculator.add("1,2,3")); // Output: 6
            System.out.println(calculator.add("1\n2,3")); // Output: 6
            System.out.println(calculator.add("//;\n1;2")); // Output: 3
            System.out.println(calculator.add("1000,999,1001")); // Output: 1999
            System.out.println(calculator.add("//[***]\n1***2***3")); // Output: 6
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
