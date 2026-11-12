package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    public void apply(FruitTransaction transaction) {
        Storage.remove(transaction.getFruit(), transaction.getQuantity());
    }
}
