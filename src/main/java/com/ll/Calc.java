package com.ll;

public class Calc {

    public static int run(String input) {

        input = input.replaceAll("- ", "+ -");

        boolean needToMulti = input.contains("*");
        boolean needToPlus = input.contains("+");

        boolean needToCompound = needToMulti && needToPlus;

        if(!input.contains(" ")){
            return Integer.parseInt(input);
        }

        if (needToCompound) {
            String[] arr = input.split(" \\+ ");
            int sum = 0;
            for (String s : arr) {
                sum += run(s);
            }
            return sum;

        } else if (needToPlus) {
            String[] arr = input.split(" \\+ ");

            int sum = 0;
            for (String s : arr) {
                sum += Integer.parseInt(s);
            }
            return sum;
        } else if (needToMulti) {
            String[] arr = input.split(" \\* ");

            int sum = 1;
            for (String s : arr) {
                sum *= Integer.parseInt(s);
            }
            return sum;
        }

        throw new RuntimeException("올바른 계산식이 아닙니다.");
    }
}
