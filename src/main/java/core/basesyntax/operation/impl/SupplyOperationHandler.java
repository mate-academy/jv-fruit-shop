package core.basesyntax.operation.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    private final FruitStorage fruitStorage;

    public SupplyOperationHandler(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void execute(FruitTransaction fruitTransaction) {
        Fruit fruit = fruitStorage.getByName(fruitTransaction.getFruit());
        fruit.setQuantity(fruit.getQuantity() + fruitTransaction.getQuantity());
        fruitStorage.put(fruit);
    }
}
