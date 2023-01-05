package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class OperationHandlerSupply implements OperationHandler {
    @Override
    public void operation(FruitTransaction fruitTransaction) {
        String fruitInStorage = fruitTransaction.getFruit();
        int currentQtyInStorage = Storage.fruitsStorage.get(fruitInStorage);
        int supplyQty = fruitTransaction.getQuantity();
        Storage.fruitsStorage.put(fruitInStorage, (currentQtyInStorage + supplyQty));
    }
}
