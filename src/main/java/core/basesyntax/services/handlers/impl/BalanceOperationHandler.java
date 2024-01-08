package core.basesyntax.services.handlers.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.services.handlers.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handleOperation(String fruit, int balanceQuantity) {
        Storage.fruitsTypeAndAmount.put(fruit, balanceQuantity);
    }
}
