package transactionexecutor;

import db.Storage;
import fruittransaction.FruitTransaction;

public class OperationHandlerBalanceImpl implements OperationHandler {

    public void handle(FruitTransaction transaction) {
        Storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}

