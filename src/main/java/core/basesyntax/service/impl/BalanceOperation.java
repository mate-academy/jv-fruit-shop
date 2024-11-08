package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.storage.FruitStorage;

public class BalanceOperation implements OperationHandler {
    private final FruitStorage storage;

    public BalanceOperation(FruitStorage storage) {
        this.storage = storage;
    }

    @Override
    public void handleOperation(FruitTransaction transaction) {
        storage.updateFruitQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
