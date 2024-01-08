package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class QuantityOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruit) {
        Storage.storage.put(fruit.getName(), fruit.getAmount());

    }
}
