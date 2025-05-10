package dev.repository;

import java.util.HashMap;
import java.util.Map;

public class RepositoryImp implements Repository {
    private final Map<String, Integer> store;

    public RepositoryImp() {
        store = new HashMap<>();
    }

    public Map<String, Integer> selectAll() {
        return store;
    }

    @Override
    public Integer selectQuantity(String fruitKey) {
        Integer quantity = store.get(fruitKey);
        return quantity != null ? quantity : 0;
    }

    @Override
    public void updateQuantity(String fruitKey, int newQuantity) {
        store.put(fruitKey, newQuantity);
    }
}
