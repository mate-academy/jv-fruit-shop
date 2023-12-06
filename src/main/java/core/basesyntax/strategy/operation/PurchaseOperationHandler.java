package core.basesyntax.strategy.operation;

import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int get(FruitTransaction fruitTransaction) {
        return -fruitTransaction.getQuantity();
    }
}
