package core.basesyntax.strategy.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    private final FruitStorage fruitStorage;

    public SupplyOperationHandler(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        fruitStorage.addFruit(transaction.getFruit(), transaction.getQuantity());
    }
}
