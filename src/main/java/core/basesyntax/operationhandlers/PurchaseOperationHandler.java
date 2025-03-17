package core.basesyntax.operationhandlers;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Storage.removeFruit(transaction.getFruit(), transaction.getQuantity());
    }
}
