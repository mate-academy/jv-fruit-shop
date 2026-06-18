package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.merge(transaction.getFruit(), transaction.getQuantity());
    }
}
