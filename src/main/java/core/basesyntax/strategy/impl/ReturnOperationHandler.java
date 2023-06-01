package core.basesyntax.strategy.impl;

import static javax.swing.UIManager.get;
import static javax.swing.UIManager.put;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int previousQuantity = (int) get(transaction.getFruit());
        put(transaction.getFruit(), previousQuantity + transaction.getQuantity());
    }
}
