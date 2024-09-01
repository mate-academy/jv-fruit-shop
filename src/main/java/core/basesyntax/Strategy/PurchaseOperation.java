package core.basesyntax.Strategy;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Storage;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Storage storage) {
        storage.removeFruit(transaction.fruit(), transaction.quantity());
    }
}
