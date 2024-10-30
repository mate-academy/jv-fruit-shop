package core.basesyntax.strategy.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private final FruitStorage fruitStorage;

    public BalanceOperationHandler(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        fruitStorage.getFruits()
                .put(transaction.getFruit(),
                        fruitStorage.getFruits().getOrDefault(transaction.getFruit(), 0)
                        + transaction.getQuantity());
    }
}
