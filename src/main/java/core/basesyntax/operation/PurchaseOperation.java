package core.basesyntax.operation;

import core.basesyntax.storage.Storage;
import core.basesyntax.transactions.FruitTransaction;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void operate(FruitTransaction transaction, Storage storage) {
        storage.remove(transaction.getFruit(), transaction.getQuantity());
    }
}
