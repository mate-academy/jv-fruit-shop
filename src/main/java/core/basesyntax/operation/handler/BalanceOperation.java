package core.basesyntax.operation.handler;

import core.basesyntax.FruitTransaction;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.storage.Storage;

public class BalanceOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        Storage.fruits.put(transaction.getFruit(), transaction.getAmount());
    }
}
