package core.basesyntax.operations;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Storage;

public class BalanceOperation implements OperationHandler {

    @Override
    public void handle(Storage storage, FruitTransaction transaction) {
        storage.setFruitQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
