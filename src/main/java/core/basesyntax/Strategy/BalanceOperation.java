package core.basesyntax.Strategy;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Storage;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Storage storage) {
        storage.addFruit(transaction.fruit(), transaction.quantity());
    }
}
