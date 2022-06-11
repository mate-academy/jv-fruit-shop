package service.impl;

import db.Storage;
import java.util.List;
import java.util.stream.Collectors;
import service.StorageService;

public class StorageImplementation implements StorageService {

    @Override
    public void add(String fruit, Integer quantity) {
        Integer newAmount = Storage.fruits.containsKey(fruit)
                ? Storage.fruits.get(fruit) + quantity : quantity;
        Storage.fruits.put(fruit, newAmount);
    }

    @Override
    public void subtract(String fruit, Integer quantity) {
        Integer newAmount = Storage.fruits.containsKey(fruit)
                ? Storage.fruits.get(fruit) - quantity : quantity;
        Storage.fruits.put(fruit, newAmount);
    }

    @Override
    public void set(String fruit, Integer quantity) {
        Storage.fruits.put(fruit, quantity);
    }

    @Override
    public List<String[]> getBalance() {
        return Storage.fruits.entrySet().stream()
                .map(i -> new String[]{i.getKey(), String.valueOf(i.getValue())})
                .collect(Collectors.toList());
    }
}
