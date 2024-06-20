package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class ReturnOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("The quantity for Return Operation can't be negative = "
                    + transaction.getQuantity());
        }
        Storage.reports.put(transaction.getFruit(), getBalance(transaction)
                + transaction.getQuantity());
    }

    private int getBalance(FruitTransaction transaction) {
        return Storage.reports.get(transaction.getFruit());
    }
}
