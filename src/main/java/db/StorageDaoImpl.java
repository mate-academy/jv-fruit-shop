package db;

import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    private Map<String, Integer> storage;

    @Override
    public void add(Map<String, Integer> fruitsToAdd) {
        for (Map.Entry<String, Integer> entry : fruitsToAdd.entrySet()) {
            if (!storage.containsKey(entry.getKey())) {
                storage.put(entry.getKey(), entry.getValue());
            } else {
                int newStock = storage.get(entry.getKey()) + entry.getValue();
                storage.put(entry.getKey(), newStock);
            }
        }
    }

    public void add(String fruitName, int fruitsNumber) {
        if (!storage.containsKey(fruitName)) {
            storage.put(fruitName, fruitsNumber);
        } else {
            int newStock = storage.get(fruitName) + fruitsNumber;
            storage.put(fruitName, newStock);
        }
    }

    @Override
    public void subtract(Map<String, Integer> fruitsToSubtract) {
        for (Map.Entry<String, Integer> entry : fruitsToSubtract.entrySet()) {
            if (!storage.containsKey(entry.getKey())) {
                throw new RuntimeException("There is no such fruit in the storage!");
            }
            int newStock = storage.get(entry.getKey()) - entry.getValue();
            if (newStock < 0) {
                throw new RuntimeException("Storage does not have so many fruits!");
            }
            storage.put(entry.getKey(), newStock);
        }
    }

    public void subtract(String fruitName, int fruitsNumber) {
        if (!storage.containsKey(fruitName)) {
            throw new RuntimeException("There is no such fruit in the storage!");
        }
        int newStock = storage.get(fruitName) - fruitsNumber;
        if (newStock < 0) {
            throw new RuntimeException("Storage does not have so many fruits!");
        }
        storage.put(fruitName, newStock);
    }

    @Override
    public int get(String fruitName) {
        return storage.get(fruitName);
    }
}
