package service.operation;

import db.Storage;
import model.Transaction;

public class SupplyOperation implements OperationHandler {
    private Storage storage = new Storage();

    public Storage getStorage() {
        return storage;
    }

    @Override
    public void performOperation(Transaction transaction) {
        storage.add(transaction.getFruit(), transaction.getQuantity());
    }
}
