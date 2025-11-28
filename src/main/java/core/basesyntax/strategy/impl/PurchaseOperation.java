package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public int handle(FruitTransaction transaction, int currentBalance) {
        int transactionQuantity = transaction.getQuantity();
        if (transactionQuantity > currentBalance) {
            throw new RuntimeException("Not enough fruit to sell. "
                    + "Attempted to purchase " + transactionQuantity
                    + " of " + transaction.getFruit()
                    + ", but only " + currentBalance + " available.");
        }
        return currentBalance - transactionQuantity;
    }
}
