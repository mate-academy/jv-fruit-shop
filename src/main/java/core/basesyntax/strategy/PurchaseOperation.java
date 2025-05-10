package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        Storage.removeFruit(transaction.getFruit(), transaction.getQuantity());
    }
}
