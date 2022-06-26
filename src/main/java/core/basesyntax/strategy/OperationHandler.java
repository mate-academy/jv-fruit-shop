package core.basesyntax.strategy;

import core.basesyntax.model.FruitShopTransactions;

public interface OperationHandler {
    void makeOperation(FruitShopTransactions fruitTransaction);
}
