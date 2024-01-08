package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruit) {
        Integer amountBefore = Storage.storage.get(fruit.getName());
        Integer amountAfter = amountBefore + fruit.getAmount();
        Storage.storage.put(fruit.getName(), amountAfter);
    }
}
