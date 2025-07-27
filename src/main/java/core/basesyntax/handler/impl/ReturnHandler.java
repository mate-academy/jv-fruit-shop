package core.basesyntax.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.FruitTransaction;

public class ReturnHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int updated = Storage.getFruitQuantity(transaction.getFruit()) + transaction.getQuantity();
        Storage.updateFruit(transaction.getFruit(), updated);
    }
}
