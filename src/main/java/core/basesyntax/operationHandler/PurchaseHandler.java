package core.basesyntax.operationHandler;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Storage;

public class PurchaseHandler implements OperationHandler{

    @Override
    public void handleOperation(FruitTransaction transaction, Storage storage) {
        Storage.fruits.remove(transaction.getFruit(), transaction.getQuantity());
    }


}
