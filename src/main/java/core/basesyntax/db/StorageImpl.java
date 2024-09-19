package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class StorageImpl implements Storage {
    private Map<String, Integer> fruitMap;

    public StorageImpl() {
        fruitMap = new HashMap<>();
    }

    @Override
    public void add(String fruit, int quantity) {
        fruitMap.put(fruit, quantity);
    }

    @Override
    public void change(String fruit, int newQuantity) {
        fruitMap.replace(fruit, newQuantity);
    }

    @Override
    public int get(String fruit) {
        return fruitMap.get(fruit);
    }

    @Override
    public Map<String, Integer> getAll() {
        return new HashMap<>(fruitMap);
    }
}
