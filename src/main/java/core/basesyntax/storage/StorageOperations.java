package core.basesyntax.storage;

import core.basesyntax.model.FruitBatch;

public interface StorageOperations {
    boolean addFruits(FruitBatch fruitBatch);

    boolean removeFruits(FruitBatch fruitBatch);

    int getStorageSize();

    String outputProducts();
}
