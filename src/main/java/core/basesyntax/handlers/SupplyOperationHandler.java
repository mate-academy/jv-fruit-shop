package core.basesyntax.handlers;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void calculateOperation(FruitTransaction transaction) {
        int currentAmount = Storage.STORAGE.get(transaction.getFruit());
        int quantity = transaction.getQuantity();
        int supplyResult = currentAmount + quantity;
        Storage.STORAGE.put(transaction.getFruit(), supplyResult);
    }
}
