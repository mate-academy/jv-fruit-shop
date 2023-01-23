package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public void process(FruitTransaction transaction) {
        if (Storage.fruits.get(transaction.getFruit()) > transaction.getQuantity()) {
            Storage.fruits.replace(transaction.getFruit(),
                    Storage.fruits.get(transaction.getFruit()),
                    Storage.fruits.get(transaction.getFruit()) - transaction.getQuantity());
        } else {
            throw new RuntimeException("Not enough quantity of "
                    + transaction.getFruit() + "on storage.");
        }
    }
}
