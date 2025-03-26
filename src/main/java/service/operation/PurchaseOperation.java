package service.operation;

import db.Storage;
import model.Transaction;

public class PurchaseOperation implements OperationHandler {
    Storage storage = new Storage();

    @Override
    public void performOperation(Transaction transaction) {
        storage.remove(transaction.getFruit(), transaction.getQuantity());
    }
}
