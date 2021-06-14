package com.company;

import java.util.*;

public class Main {
    public static <T> Collection<T> removeDuplicates(Collection<T> collection) {
        return new HashSet<>(collection);
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("q", "w", "e", "r", "q", "w", "e", "r", "a", "z");
        Collection<String> res = removeDuplicates(list);
        System.out.println(res);
    }
}