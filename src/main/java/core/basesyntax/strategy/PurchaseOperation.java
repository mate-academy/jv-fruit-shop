package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.db.Storage;

public class PurchaseOperation implements OperationHandler {
    public void apply(FruitTransaction transaction) {
        Storage.remove(transaction.getFruit(), transaction.getQuantity());
    }
}
