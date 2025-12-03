package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class day3 {
    public static int part1(ArrayList<String> input) {
        int sum = 0;

        for (String bank : input) {
            int max = 0;
            for (int i = 0; i < bank.length(); i++) {
                for (int j = i + 1; j < bank.length(); j++) {
                    int num = Integer.parseInt(bank.charAt(i) + "" + bank.charAt(j));
                    if (num > max) {
                        max = num;
                    }
                }
            }
            sum += max;
        }
        return sum;
    }

    public static long part2(ArrayList<String> input) {
        long sum = 0;

        for (String bank : input) {
            int[] digits = new int[12];
            int[] digitIdx = new int[12];
            for (int i = 0; i < bank.length() - 11; i++) {
                int digit = Integer.parseInt(String.valueOf(bank.charAt(i)));
                if (digit > digits[0]){
                    digits[0] = digit;
                    digitIdx[0] = i;
                }
            }

            for (int i = 1; i < 12; i++) {
                for (int j = digitIdx[i - 1]+1; j < bank.length() - (11-i); j++) {
                    int digit = Integer.parseInt(String.valueOf(bank.charAt(j)));
                    if (digit > digits[i]){
                        digits[i] = digit;
                        digitIdx[i] = j;
                    }
                }
            }

            StringBuilder num = new StringBuilder();
            for (int i = 0; i < 12; i++) {
                num.append(digits[i]);
            }

            System.out.println(num.toString());
            long max = Long.parseLong(num.toString());
            sum += max;

        }

        return sum;
    }

    public static void main(String[] args) {

        ArrayList<String> input = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("inputs/input_3"))) {
            String line;
            while ((line = br.readLine()) != null) {
                input.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        long sum = part2(input);
        System.out.println(sum);
    }
}