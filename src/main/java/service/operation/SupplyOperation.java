package service.operation;

import db.Storage;
import model.Transaction;

public class SupplyOperation implements OperationHandler {
    Storage storage = new Storage();

    @Override
    public void performOperation(Transaction transaction) {
        storage.add(transaction.getFruit(), transaction.getQuantity());
    }
}
