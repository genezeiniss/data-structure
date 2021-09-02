package com.genezeiniss.data_structure.challange.number;

/**
 * You might know some pretty large perfect squares. But what about the NEXT one?
 * Complete the findNextSquare method that finds the next integral perfect square after the one passed as a parameter.
 * Recall that an integral perfect square is an integer n such that sqrt(n) is also an integer.
 * If the parameter is itself not a perfect square then -1 should be returned. You may assume the parameter is non-negative.
 */
public class NumberFun {

    public static long findNextSquare(long sq) {
        if (sq <= 0) {
            return -1;
        }
        double root = Math.sqrt(sq);
        return isPerfectSquare(root) ? nextSquare(root) : -1;
    }

    /* Math.floor() returns closest integer value, for
     * example Math.floor of 984.1 is 984, so if the value
     * of sq is non integer than the below expression would
     * be non-zero.
     */
    private static boolean isPerfectSquare(double root) {
        return (root - Math.floor(root)) == 0;
    }

    private static long nextSquare(double root) {
        root += 1;
        return (long) (root * root);
    }

    public static void main(String[] args) {
        System.out.println(findNextSquare(625));
    }
}
