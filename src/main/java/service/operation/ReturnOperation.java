package service.operation;

import db.Storage;
import model.Transaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void performOperation(Transaction transaction) {
        Storage storage = new Storage();
        storage.add(transaction.getFruit(), transaction.getQuantity());
    }
}
