package core.basesyntax.operationhandlers;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransactionImpl;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransactionImpl transaction) {
        Storage.removeFruit(transaction.getFruit(), transaction.getQuantity());
    }
}
