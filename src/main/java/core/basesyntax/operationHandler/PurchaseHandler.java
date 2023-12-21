package core.basesyntax.operationHandler;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Storage;

public class PurchaseHandler implements OperationHandler{

    @Override
    public void handleOperation(FruitTransaction transaction, Storage storage) {

        Storage.fruits.put(transaction.getFruit(), Storage.fruits.get(transaction.getFruit()) - transaction.getQuantity());


    }


}
