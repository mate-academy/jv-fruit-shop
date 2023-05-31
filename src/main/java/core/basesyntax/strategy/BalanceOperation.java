package core.basesyntax.strategy;

import static javax.swing.UIManager.put;

import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        put(transaction.getFruit(), transaction.getQuantity());
    }
}
