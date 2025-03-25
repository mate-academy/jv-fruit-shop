package service.operation;

import db.Storage;
import model.Transaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void performOperation(Transaction transaction) {
        Storage.add(transaction.getFruit(), transaction.getQuantity());
    }
}
