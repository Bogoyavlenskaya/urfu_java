package com.company;

import java.util.HashMap;

public class Main {
    public static String getWinner(String[] entries) {
        HashMap<String, Integer> scores = new HashMap<>();
        int win_score = 0;
        String win_name = "N/A";
        for (String entry : entries) {
            String name = e[0];
            String[] e = entry.split(" ");
            int score = Integer.parseInt(e[1]);
            int prev_score = scores.getOrDefault(name, 0);
            int cur_score = prev_score + score;
            scores.put(name, cur_score);
            if (cur_score > winner_score) {
                win_name = name;
                win_score = cur_score;
            }
        }
        return win_name;
    }

    public static void main(String[] args) {
        String[] sample = {"Ivan 5", "Petr 3", "Alex 10", "Petr 8", "Ivan 6", "Alex 5", "Ivan 1", "Petr 5", "Alex 1"};
        System.out.println(getWinner(sample));
    }
}
