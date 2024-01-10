package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruit) {
        Storage.storage.merge(fruit.getName(),fruit.getAmount(), Integer::sum);
    }
}
