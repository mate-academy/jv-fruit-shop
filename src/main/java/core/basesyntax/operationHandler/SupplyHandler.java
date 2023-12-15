package core.basesyntax.operationHandler;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Storage;

public class SupplyHandler implements OperationHandler{
    @Override
    public void handleOperation(FruitTransaction transaction, Storage storage) {
        storage.supplyFruit(transaction.getFruit(), transaction.getQuantity());

    }


}
