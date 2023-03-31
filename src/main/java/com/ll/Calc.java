package com.ll;

public class Calc {

    public static int run(String input) {
        input = input.replaceAll("- ", "+ -");

        String[] arr = input.split(" \\+ ");

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Integer.parseInt(arr[i]);
        }
        return sum;
    }
}
