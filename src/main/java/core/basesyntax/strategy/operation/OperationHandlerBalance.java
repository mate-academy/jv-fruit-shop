package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class OperationHandlerBalance implements OperationHandler {
    @Override
    public void operation(FruitTransaction fruitTransaction) {
        Storage.fruitsStorage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
