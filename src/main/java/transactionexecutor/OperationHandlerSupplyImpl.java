package transactionexecutor;

import db.Storage;
import fruittransaction.FruitTransaction;

public class OperationHandlerSupplyImpl implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction) {
        Integer quantityFruitsFromStorage = Storage.getStorage().get(transaction.getFruit());
        Storage.put(transaction.getFruit(),
                quantityFruitsFromStorage + transaction.getQuantity());
    }
}

