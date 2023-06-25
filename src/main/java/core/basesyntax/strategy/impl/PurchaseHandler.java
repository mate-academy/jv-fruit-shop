package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationHandler;

public class PurchaseHandler implements OperationHandler {

    @Override
    public int executeOperation(int currentQuantity, int quantityFromTransaction) {
        if (currentQuantity >= quantityFromTransaction) {
            return currentQuantity - quantityFromTransaction;
        }
        throw new RuntimeException("Quantity of fruits is nor enough for purchase");
    }
}
