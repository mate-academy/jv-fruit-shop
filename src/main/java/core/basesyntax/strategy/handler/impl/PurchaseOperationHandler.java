package core.basesyntax.strategy.handler.impl;

import core.basesyntax.strategy.handler.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public int operate(int transaction, int oldValue) {
        if (oldValue < transaction) {
            throw new RuntimeException("Fruit not enough");
        }
        return oldValue - transaction;
    }
}
