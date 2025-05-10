package core.basesyntax.service.operations;

import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public int getOperation(FruitTransaction fruitTransaction) {
        return fruitTransaction.getQuantity() * (-1);
    }
}
