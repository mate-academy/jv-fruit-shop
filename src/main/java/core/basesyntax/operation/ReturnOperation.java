package core.basesyntax.operation;

import core.basesyntax.storage.Storage;
import core.basesyntax.transactions.FruitTransaction;

public class ReturnOperation implements OperationHandler {

    @Override
    public void operate(FruitTransaction transaction, Storage storage) {
        storage.add(transaction.getFruit(), transaction.getQuantity());
    }
}
