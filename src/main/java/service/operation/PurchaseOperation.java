package service.operation;

import db.Storage;
import model.Transaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void performOperation(Transaction transaction) {
        Storage storage = new Storage();
        storage.remove(transaction.getFruit(), transaction.getQuantity());
    }
}
