package core.basesyntax.strategy;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    void handleOperation(FruitTransaction fruitTransaction, FruitStorageDao fruitStorageDao);
}
