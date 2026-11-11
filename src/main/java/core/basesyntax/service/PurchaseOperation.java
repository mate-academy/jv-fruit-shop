package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Storage;

public class PurchaseOperation implements OperationHandler {
    public void apply(FruitTransaction transaction) {
        Storage.remove(transaction.getFruit(), transaction.getQuantity());
    }
}
