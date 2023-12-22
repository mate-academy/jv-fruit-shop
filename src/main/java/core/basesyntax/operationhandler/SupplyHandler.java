package core.basesyntax.operationhandler;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Storage;

public class SupplyHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction, Storage storage) {
        Storage.fruits.merge(transaction.getFruit(), transaction.getQuantity(), Integer::sum);
    }
}
