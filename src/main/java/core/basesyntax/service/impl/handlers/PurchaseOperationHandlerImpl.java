package core.basesyntax.service.impl.handlers;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction) {
        Storage.fruits.merge(
                fruitTransaction.getFruit(),
                fruitTransaction.getQuantity(),
                (oldValue, newValue) -> oldValue - newValue);
    }
}
