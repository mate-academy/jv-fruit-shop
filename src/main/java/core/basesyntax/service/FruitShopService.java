package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operations.OperationHandler;

public interface FruitShopService {
    void process(FruitTransaction fruitTransaction,
                 OperationHandler operation);
}
