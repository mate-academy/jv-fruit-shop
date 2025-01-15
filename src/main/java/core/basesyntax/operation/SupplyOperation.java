package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Storage;

public class SupplyOperation implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction, Storage storage) {
        storage.supply(transaction.getFruit(), transaction.getQuantity());
    }
}
