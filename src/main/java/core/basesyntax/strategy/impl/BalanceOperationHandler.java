package core.basesyntax.strategy.impl;

import static javax.swing.UIManager.put;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("Balance must be positive");
        }
        put(transaction.getFruit(), transaction.getQuantity());
    }
}
