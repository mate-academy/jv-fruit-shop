package core.basesyntax.strategy.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperation implements OperationHandler {
    private final FruitStorage storage;

    public BalanceOperation(FruitStorage storage) {
        this.storage = storage;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        storage.setQuantity(transaction.getFruit(), transaction.getQuantity());
    }

}
