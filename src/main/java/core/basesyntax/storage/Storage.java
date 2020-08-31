package core.basesyntax.storage;

import core.basesyntax.model.FruitBatch;
import java.util.HashMap;
import java.util.Map;

public class Storage implements StorageOperations {
    private final Map<String,FruitBatch> storage = new HashMap<>();

    @Override
    public boolean addFruits(FruitBatch fruitBatch) {
        if (fruitBatch == null) {
            throw new IllegalArgumentException("Cannot add null fruit batch");
        }
        String fruitName = fruitBatch.getFruitName();
        FruitBatch storageBatch = storage.get(fruitName);
        if (isValidBatch(fruitBatch, storageBatch)) {
            storageBatch.setAmount(storageBatch.getAmount() + fruitBatch.getAmount());
            return true;
        }
        if (storageBatch == null) {
            storage.put(fruitBatch.getFruitName(), fruitBatch);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeFruits(FruitBatch fruitBatch) {
        if (fruitBatch == null) {
            throw new IllegalArgumentException("Cannot remove null fruit batch");
        }
        String fruitName = fruitBatch.getFruitName();
        FruitBatch storageBatch = storage.get(fruitName);
        if (isValidBatch(fruitBatch, storageBatch)) {
            storageBatch.setAmount(storageBatch.getAmount() - fruitBatch.getAmount());
            return true;
        }
        return false;
    }

    @Override
    public int getStorageSize() {
        return storage.size();
    }

    @Override
    public String outputProducts() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, FruitBatch> entry: storage.entrySet()) {
            stringBuilder.append(entry.getKey()).append(", ")
                    .append(entry.getValue().getAmount())
                    .append("\n");
        }
        return stringBuilder.toString().trim();
    }

    private boolean isValidBatch(FruitBatch fruitBatch, FruitBatch storageBatch) {
        return storageBatch != null
                && storageBatch.getAmount() >= fruitBatch.getAmount()
                && (storageBatch.getBatchDay().isBefore(fruitBatch.getBatchDay())
                || storageBatch.getBatchDay().isEqual(fruitBatch.getBatchDay()));
    }
}
