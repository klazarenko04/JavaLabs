package org.example;

public class StringCalculator {

    public int add(String numbers) {
        // Check if the input string is empty
        if (numbers.isEmpty()) {
            return 0;
        }

        // Split the input string by commas
        String[] numArray = numbers.split(",");

        // Initialize sum to 0
        int sum = 0;

        // Iterate through the numbers and add them to the sum
        for (String num : numArray) {
            // Check for consecutive commas or empty values
            if (num.isEmpty()) {
                throw new IllegalArgumentException("Input contains consecutive commas or empty values");
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
            System.out.println(calculator.add(""));      // Output: 0
            System.out.println(calculator.add("1"));     // Output: 1
            System.out.println(calculator.add("1,2"));   // Output: 3
            System.out.println(calculator.add("1,2,3")); // Output: 6
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}