package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Storage;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Storage storage) {
        storage.purchase(transaction.getFruit(), transaction.getQuantity());
    }
}
