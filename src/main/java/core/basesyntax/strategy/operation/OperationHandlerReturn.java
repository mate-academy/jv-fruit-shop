package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class OperationHandlerReturn implements OperationHandler {
    @Override
    public void operation(FruitTransaction fruitTransaction) {
        String fruitInStorage = fruitTransaction.getFruit();
        int currentQtyInStorage = Storage.fruitsStorage.get(fruitInStorage);
        int returnQty = fruitTransaction.getQuantity();
        Storage.fruitsStorage.put(fruitInStorage, (currentQtyInStorage + returnQty));
    }
}
