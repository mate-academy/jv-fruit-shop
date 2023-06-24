package transactionexecutor;

import db.Storage;
import fruittransaction.FruitTransaction;

public class OperationHandlerReturnImpl implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction) {
        Integer quantityFruitsFromStorage = Storage.getStorage().get(transaction.getFruit());
        Storage.put(transaction.getFruit(),
                quantityFruitsFromStorage + transaction.getQuantity());
    }
}
