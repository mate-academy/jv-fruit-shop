package core.basesyntax.service.quantity;

import core.basesyntax.entity.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public FruitTransaction getTransitionTransaction(FruitTransaction fruitTransaction) {

        return fruitTransaction;
    }
}
