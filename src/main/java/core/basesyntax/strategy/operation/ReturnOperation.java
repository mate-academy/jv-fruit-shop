package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruit) {
        Integer amountBefore = Storage.storage.get(fruit.getName());
        Integer valueAfter = amountBefore + fruit.getAmount();
        Storage.storage.put(fruit.getName(), valueAfter);
    }
}
