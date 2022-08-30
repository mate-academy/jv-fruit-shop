package core.basesyntax.strategy.handlers;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    private Storage storage;

    public BalanceOperationHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void applyOperation(FruitTransaction fruitTransaction) {
        Fruit fruit = new Fruit(fruitTransaction.getFruit());
        storage.add(fruit, fruitTransaction.getQuantity());
    }
}
