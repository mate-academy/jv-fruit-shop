package core.basesyntax.service.impl;

import static javax.swing.UIManager.get;
import static javax.swing.UIManager.put;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int previousQuantity = (int) get(transaction.getFruit());
        if (transaction.getQuantity() > previousQuantity) {
            throw new RuntimeException("There is no enough fruits");
        }
        put(transaction.getFruit(), previousQuantity - transaction.getQuantity());
    }
}
