package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {

    @Override
    public void process(FruitTransaction transaction) {
        Storage.fruits.replace(transaction.getFruit(), Storage.fruits.get(transaction.getFruit()),
                Storage.fruits.get(transaction.getFruit()) + transaction.getQuantity());
    }
}
