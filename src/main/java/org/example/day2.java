package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class day2 {

    public static long part1(String[] ranges){
        long sum = 0;

        for (String range : ranges) {
            long start = Long.parseLong(range.split("-")[0]);
            long end = Long.parseLong(range.split("-")[1]);

            for (long i = start; i <= end; i++) {
                int len = Long.toString(i).length();
                if (!(len % 2 == 1)) {
                    if (Long.toString(i).substring(0, len/2).equals(Long.toString(i).substring(len/2))) {
                        sum += i;
                    }
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        ArrayList<String> input = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("inputs/input_2"))) {
            String line;
            while ((line = br.readLine()) != null) {
                input.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        String[] ranges = input.getFirst().split(",");

        long sum = 0;

        for (String range : ranges) {
            long start = Long.parseLong(range.split("-")[0]);
            long end = Long.parseLong(range.split("-")[1]);

            for (long i = start; i <= end; i++) {
                int len = Long.toString(i).length();
                for (int j = 1; j < len; j++){
                    if (len % j == 0){
                        String sub =  Long.toString(i).substring(0, j);
                        String test = "";

                        while (test.length() < len){
                            test += sub;
                        }


                        if (test.equals(Long.toString(i))){
                            sum += i;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(sum);

    }
}