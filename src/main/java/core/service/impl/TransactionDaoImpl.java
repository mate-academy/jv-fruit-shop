package core.service.impl;

import core.checker.Checker;
import core.db.Storage;
import core.service.TransactionDao;
import java.util.HashMap;
import java.util.Map;

public class TransactionDaoImpl implements TransactionDao {
    private final Storage storage;
    private final Checker checker;
    
    public TransactionDaoImpl(Storage storage, Checker checker) {
        this.storage = storage;
        this.checker = checker;
    }
    
    @Override
    public void set(String fruit, int quantity) {
        checker.validateNewEntry(fruit, quantity);
        storage.put(fruit, quantity);
    }

    @Override
    public void add(String fruit, int quantity) {
        checker.validateFruit(fruit);
        checker.validateQuantity(quantity);

        int current = storage.getQuantity(fruit)
                .orElseThrow(() -> new RuntimeException("Cannot find fruit"));

        int newValue = current + quantity;
        storage.put(fruit, newValue);
    }

    @Override
    public void subtract(String fruit, int quantity) {
        checker.validateFruit(fruit);
        checker.validateQuantity(quantity);
        
        int currentValue = storage.getQuantity(fruit)
                .orElseThrow(() -> new RuntimeException("Cannot find fruit"));
        
        int newValue = currentValue - quantity;
        
        if (newValue < 0) {
            throw new RuntimeException("balance can't be negative");
        }
        storage.put(fruit, newValue);
    }
    
    @Override
    public Map<String, Integer> getAll() {
        return new HashMap<>(storage.getStorage());
    }
}
