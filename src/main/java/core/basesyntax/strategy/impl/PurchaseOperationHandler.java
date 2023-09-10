package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int operate(Integer oldAmount, Integer newAmount) {
        if (oldAmount < newAmount) {
            throw new RuntimeException(getPurchaseErrorMessage(oldAmount, newAmount));
        }
        return oldAmount - newAmount;
    }

    private String getPurchaseErrorMessage(Integer oldAmount, Integer newAmount) {
        return String.format("Can't buy %d. Only %d fruits are available on stock",
                newAmount, oldAmount);
    }
}
