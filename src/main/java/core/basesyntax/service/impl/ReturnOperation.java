package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.storage.FruitStorage;

public class ReturnOperation implements OperationHandler {
    private final FruitStorage storage;

    public ReturnOperation(FruitStorage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        storage.addFruit(transaction.getFruit(), transaction.getQuantity());
    }
}
