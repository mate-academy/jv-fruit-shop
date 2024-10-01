package core.basesyntax.strategy;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void updateFruitStorage(FruitTransaction fruitTransaction, FruitStorageDao fruitStorageDao);
}
