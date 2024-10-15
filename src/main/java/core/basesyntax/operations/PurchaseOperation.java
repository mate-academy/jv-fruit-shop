package core.basesyntax.operations;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Storage;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void handle(Storage storage, FruitTransaction transaction) {
        storage.reduceFruitQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
