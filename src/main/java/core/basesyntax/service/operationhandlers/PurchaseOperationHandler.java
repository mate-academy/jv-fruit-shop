package core.basesyntax.service.operationhandlers;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.FRUIT_STORAGE.merge(transaction.getFruit(),-transaction.getAmount(), Integer::sum);
    }
}
