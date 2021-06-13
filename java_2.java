// Задание 1
    public static <T> Collection<T> removeDuplicates(Collection<T> collection) {
        return new HashSet<>(collection);
}

//  Задание 2
public static <K, V> Map<V, Collection<K>> inverse(Map<? extends K, ? extends V> map){
        Map<V, Collection<K>> resultMap = new HashMap<>();
        Set<K> keys = map.keySet();
        for(K key : keys){
            V value = map.get(key);
            resultMap.compute(value, (v, k) -> {
                if(k == null){
                    k = new HashSet<>();
                }
                k.add(key);
                return k;
            });
        }
        return resultMap;
}