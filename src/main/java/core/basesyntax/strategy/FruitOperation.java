package core.basesyntax.strategy;

import core.basesyntax.db.StorageDao;

public interface FruitOperation {
    void operate(String fruitName, int amount, StorageDao storageDao);
}
