package core.basesyntax.service.impl;

import static javax.swing.UIManager.put;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        if (transaction.getQuantity() == 0) {
            throw new RuntimeException("No fruits available");
        }
        put(transaction.getFruit(), transaction.getQuantity());
    }
}
