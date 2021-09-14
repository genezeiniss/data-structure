package com.genezeiniss.data_structure.challange.array;

/**
 * Write a function that accepts an array of 10 integers (between 0 and 9),
 * that returns a string of those numbers in the form of a phone number.
 * The returned format must be correct in order to complete this challenge.
 * Don't forget the space after the closing parentheses!
 */
public class CreatePhoneNumber {

    public static String createPhoneNumber(int[] numbers) {

        StringBuilder prefix = new StringBuilder();
        StringBuilder firstPart = new StringBuilder();
        StringBuilder lastPart = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            if (i < 3) {
                prefix.append(numbers[i]);
            } else if (i < 6) {
                firstPart.append(numbers[i]);
            } else {
                lastPart.append(numbers[i]);
            }
        }

        return String.format("(%s) %s-%s", prefix, firstPart, lastPart);
    }

    public static String createPhoneNumberOtherSolution(int[] numbers) {

        String phoneNumber = "(xxx) xxx-xxxx";

        for (int i : numbers) {
            phoneNumber = phoneNumber.replaceFirst("x", Integer.toString(i));
        }

        return phoneNumber;
    }

    public static void main(String[] args) {
        createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
    }
}
