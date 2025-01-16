package core.basesyntax.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction, Storage storage) {
        storage.supply(transaction.getFruit(), transaction.getQuantity());
    }
}
