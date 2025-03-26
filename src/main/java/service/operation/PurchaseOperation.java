package service.operation;

import db.Storage;
import model.Transaction;

public class PurchaseOperation implements OperationHandler {
    private Storage storage = new Storage();

    public Storage getStorage() {
        return storage;
    }

    @Override
    public void performOperation(Transaction transaction) {
        storage.remove(transaction.getFruit(), transaction.getQuantity());
    }
}
