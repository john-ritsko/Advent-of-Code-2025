package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class day1 {
    static int pos = 50;

    public static int part1(ArrayList<String> input){
        int count = 0;

        for (String str : input) {
            String dir = str.substring(0, 1);
            int clicks = Integer.parseInt(str.substring(1));

            if (dir.equals("L")){
                clicks = clicks * -1;
            }

            pos += clicks;

            while(pos < 0){
                pos += 100;
            }

            while(pos > 99){
                pos -= 100;
            }

            if (pos == 0){
                count++;
            }
        }

        return count;
    }

    public static int part2(ArrayList<String> input) throws RuntimeException {
        int count = 0;
        int oldPos;

        for (String str : input) {
            oldPos = pos;
            String dir = str.substring(0, 1);
            int clicks = Integer.parseInt(str.substring(1));

            if (dir.equals("L")){
                clicks = clicks * -1;
            }

            pos += clicks;

            while(pos < 0){
                count++;
                pos += 100;
            }

            while(pos > 99){
                if (pos != 100) {
                    count++;
                }
                pos -= 100;
            }

            if(oldPos == 0 && dir.equals("L")){
                count--;
            }

            if(oldPos == 0 && dir.equals("R") && clicks % 100 == 0){
                count--;
            }

            if (pos == 0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("inputs/input_1"))) {
            String line;
            while ((line = br.readLine()) != null) {
                input.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int count = part2(input);

        System.out.println(count);
    }
}