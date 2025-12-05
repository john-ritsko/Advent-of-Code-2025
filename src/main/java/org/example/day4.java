package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class day4 {

    public static int checkAccessible(ArrayList<ArrayList<Character>> map, int x, int y){
        int count = 0;
        for (int i = Math.max(0, x-1); i <= Math.min(map.get(0).size()-1, x+1); i++) {
            for (int j = Math.max(0, y-1); j <= Math.min(map.size()-1, y+1); j++) {
                if (!(i == x && j == y) && map.get(j).get(i) == '@'){
                    count++;
                }
            }
        }
        if (count < 4){
            return 1;
        } else{
            return 0;
        }
    }

    public static int part1(ArrayList<ArrayList<Character>> map){
        int count = 0;

        for (int j = 0; j < map.size(); j++) {
            for (int i = 0; i < map.get(0).size(); i++) {
                if (map.get(j).get(i) == '@') {
                    int check = checkAccessible(map, i, j);
                    count+= check;
                }
            }
        }

        return count;
    }

    public static int part2(ArrayList<ArrayList<Character>> map){
        int count = 0;
        int removed = -1;

        while (removed != 0) {
            removed = 0;
            ArrayList<ArrayList<Character>> newMap = new ArrayList<>();

            for (ArrayList<Character> row : map) {
                newMap.add(new ArrayList<>(row));
            }

            for (int j = 0; j < map.size(); j++) {
                for (int i = 0; i < map.get(0).size(); i++) {
                    if (map.get(j).get(i) == '@') {
                        int check = checkAccessible(map, i, j);
                        removed += check;
                        if (check == 1) {
                            newMap.get(j).set(i, 'X');
                        }
                    }
                }
            }
            count += removed;
            map = new ArrayList<>();

            for (ArrayList<Character> row : newMap) {
                map.add(new ArrayList<>(row));
            }
        }
        return count;
    }

    public static void main(String[] args) {

        ArrayList<String> input = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("inputs/input_4"))) {
            String line;
            while ((line = br.readLine()) != null) {
                input.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ArrayList<ArrayList<Character>> map = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            map.add(new ArrayList<>());
            for (int j = 0; j < input.get(i).length(); j++) {
                map.get(i).add(input.get(i).charAt(j));
            }
        }

        int count = part2(map);

        System.out.println(count);
    }
}