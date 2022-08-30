package core.basesyntax.strategy.handlers;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    private Storage storage;

    public ReturnOperationHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void applyOperation(FruitTransaction fruitTransaction) {
        Fruit fruit = new Fruit(fruitTransaction.getFruit());
        storage.add(fruit, fruitTransaction.getQuantity());
    }
}
