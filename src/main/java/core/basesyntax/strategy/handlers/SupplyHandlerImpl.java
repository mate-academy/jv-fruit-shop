package core.basesyntax.strategy.handlers;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyHandlerImpl implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruitName();
        Integer storageFruitQuantity = Storage.storage.get(fruitName);
        int fruitQuantity = fruitTransaction.getQuantity();
        Storage.storage.replace(fruitName,
                storageFruitQuantity == null ? 0 : storageFruitQuantity + fruitQuantity);
    }
}
