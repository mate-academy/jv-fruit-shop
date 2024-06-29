package dev.repository;

import java.util.HashMap;
import java.util.Map;

public class RepositoryImp implements Repository {
    private Map<String, Integer> store;

    public RepositoryImp() {
        store = new HashMap<>();
    }

    @Override
    public Integer readQuantity(String fruitKey) {
        Integer quantity = store.get(fruitKey);
        return quantity != null ? quantity : 0;
    }

    @Override
    public void updateQuantity(String fruitKey, int newQuantity) {
        store.put(fruitKey, newQuantity);
    }
}
