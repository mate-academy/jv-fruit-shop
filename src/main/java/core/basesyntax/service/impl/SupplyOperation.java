package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.storage.FruitStorage;

public class SupplyOperation implements OperationHandler {
    private final FruitStorage storage;

    public SupplyOperation(FruitStorage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        storage.addFruit(transaction.getFruit(), transaction.getQuantity());
    }
}
