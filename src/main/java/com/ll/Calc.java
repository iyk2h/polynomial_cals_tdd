package com.ll;

public class Calc {

    public static int run(String input) {
        String[] arr = input.split(" \\+ ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        return a + b;
    }
}
