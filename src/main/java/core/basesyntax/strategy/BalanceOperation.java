package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;

public class BalanceOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
