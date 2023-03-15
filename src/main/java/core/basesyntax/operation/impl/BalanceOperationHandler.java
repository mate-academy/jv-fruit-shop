package core.basesyntax.operation.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private final FruitStorage fruitStorage;

    public BalanceOperationHandler(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void execute(FruitTransaction fruitTransaction) {
        fruitStorage.put(new Fruit(fruitTransaction.getFruit(), fruitTransaction.getQuantity()));
    }
}
