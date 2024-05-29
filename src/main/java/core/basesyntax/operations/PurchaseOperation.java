package core.basesyntax.operations;

import core.basesyntax.FruitTransaction;
import core.basesyntax.OperationHandler;
import core.basesyntax.Storage;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction, Storage storage) {
        storage.removeFruit(transaction.getFruit(), transaction.getQuantity());
    }
}
