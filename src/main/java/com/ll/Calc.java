package com.ll;

public class Calc {

    public static int run(String input) {
        boolean isContainsPlus = input.contains("+");
        boolean isContainsMinus = input.contains("-");


        String[] arr = null;

        if (isContainsPlus) {
            arr = input.split(" \\+ ");
        } else if (isContainsMinus) {
            arr =input.split(" \\- ");
        }

        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);

        if (isContainsPlus) {
            return a + b;
        } else if (isContainsMinus) {
            return a - b;
        }

        throw new RuntimeException("올바른 계산식이 아닙니다.");
    }
}
