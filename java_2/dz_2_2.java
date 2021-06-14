package com.company;

import java.util.*;

public class Main {
    public static <K, V> Map<V, Collection<K>> inverse(Map<? extends K, ? extends V> map){
        Map<V, Collection<K>> resultMap = new HashMap<>();
        Set<K> keys = map.keySet();
        for(K key : keys){
            V value = map.get(key);
            resultMap.compute(value, (v, ks) -> {
                if(ks == null){
                    ks = new HashSet<>();
                }
                ks.add(key);
                return ks;
            });
        }
        return resultMap;
    }

    public static void main(String[] args) {
        HashMap<String, String> mapping = new HashMap<>();
        mapping.put("state_1", "11");
        mapping.put("state_2", "12");
        mapping.put("state_3", "13");
        mapping.put("state_4", "14");
        mapping.put("state_5", "15");
        System.out.println(mapping);

        Map<String, Collection<String>> inverse_map = inverse(mapping);
        System.out.println(resultMap);
    }
}
