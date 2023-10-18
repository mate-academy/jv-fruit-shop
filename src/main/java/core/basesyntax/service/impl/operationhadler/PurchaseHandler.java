package core.basesyntax.service.impl.operationhadler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        int result = Storage.fruitsStorage.get(transaction.getFruit())
                - transaction.getQuantity();
        if (result < 0) {
            throw new RuntimeException("Not enough fruits!");
        }
        Storage.fruitsStorage.put(transaction.getFruit(), result);
    }
}
