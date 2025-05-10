package core.basesyntax.operations;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Storage;

public class SupplyOperation implements OperationHandler {

    @Override
    public void handle(Storage storage, FruitTransaction transaction) {
        storage.addFruitQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
