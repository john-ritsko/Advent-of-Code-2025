package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class template {

    public static void main(String[] args) {

        ArrayList<String> input = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("inputs/test_X"))) {
            String line;
            while ((line = br.readLine()) != null) {
                input.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}