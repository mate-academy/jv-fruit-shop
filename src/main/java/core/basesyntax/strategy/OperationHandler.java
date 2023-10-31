package core.basesyntax.strategy;

import core.basesyntax.dao.FruitStorageDao;

public interface OperationHandler {
    void operate(String fruit, int quantity, FruitStorageDao fruitStorageDao);
}
