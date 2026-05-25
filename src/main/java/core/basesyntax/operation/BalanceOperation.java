package core.basesyntax.operation;

import core.basesyntax.storage.Storage;
import core.basesyntax.transactions.FruitTransaction;

public class BalanceOperation implements OperationHandler {

    @Override
    public void operate(FruitTransaction transaction, Storage storage) {
        storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
