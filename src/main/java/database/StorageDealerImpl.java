package database;

import java.util.Map;

public class StorageDealerImpl implements StorageDealer {
    @Override
    public void checkBalance(Map<String, Integer> transactions) {
        transactions.entrySet().stream()
                .filter(entry -> entry.getValue() < 0)
                .findAny()
                .ifPresent(entry -> {
                    throw new RuntimeException("Negative balance for fruit: " + entry.getKey()
                            + " with quantity: " + entry.getValue());
                });
    }

    @Override
    public void updateDatabase(Map<String, Integer> transactions) {
        Storage.updateStorage(transactions);
    }
}
