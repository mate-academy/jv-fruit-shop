package dev.repository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryFruitStore implements FruitStore {
    private final Map<String, Integer> store;

    public InMemoryFruitStore() {
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
