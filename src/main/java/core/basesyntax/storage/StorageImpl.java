package core.basesyntax.storage;

import java.util.HashMap;
import java.util.Map;

public class StorageImpl implements Storage {
    private Map<String, Integer> transactions;

    public StorageImpl() {
        this.transactions = new HashMap<>();
    }

    @Override
    public Map<String, Integer> getAll() {
        return new HashMap<>(this.transactions);
    }

    @Override
    public Integer getQuantity(String fruit) {
        return transactions.getOrDefault(fruit, 0);
    }

    @Override
    public void put(String fruit, int quantity) {

        transactions.put(fruit, quantity);
    }

    @Override
    public void add(String fruit, int quantity) {
        int current = transactions.getOrDefault(fruit, 0);
        transactions.put(fruit, current + quantity);
    }

    @Override
    public void remove(String fruit, int quantity) {
        int current = transactions.getOrDefault(fruit, 0);

        if (current >= quantity) {
            transactions.put(fruit, current - quantity);
        } else {
            throw new RuntimeException("Current value is lower than quantity");
        }
    }
}
