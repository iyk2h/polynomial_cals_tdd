package com.ll;

public class Calc {

    public static int run(String input) {
        System.out.println(input);
        input = stripOuterBrachets(input);

        input = input.replaceAll("- ", "+ -");

        if (!input.contains(" ")) {
            return Integer.parseInt(input);
        }

        boolean needToMulti = input.contains("*");
        boolean needToPlus = input.contains("+");

        boolean needToCompound = needToMulti && needToPlus;
        boolean needToSplit = input.contains("(") && input.contains(")");
        boolean isSingleBracket = input.contains("(") || input.contains(")");

        if (needToSplit) {
            int startIdx = -1;
            int endIdx = 0;

            int cntOpen = 0;

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '(') {
                    cntOpen++;
                    if (startIdx == -1) {
                        startIdx = i;
                    }
                } else if (input.charAt(i) == ')') {
                    cntOpen--;
                    if (cntOpen == 0) {
                        endIdx = i;

                        String firstInput = input.substring(0, startIdx);
                        String midInput = input.substring(startIdx, endIdx + 1);
                        String lastInput = input.substring(endIdx + 1);

                        input = firstInput + Calc.run(midInput) + lastInput;
                    }
                }
            }
            return Calc.run(input);
        }

        if (isSingleBracket) {
            throw new RuntimeException("올바른 계산식이 아닙니다.");
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

    private static String stripOuterBrachets(String input) {
        while (input.charAt(0) == '(' && input.charAt(input.length() - 1) == ')') {
            input = input.substring(1, input.length() - 1);
        }
        return input;
    }
}
