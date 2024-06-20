package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("The quantity for Purchase Operation can't be negative = "
                    + transaction.getQuantity());
        }
        int finalBalance = getBalance(transaction) - transaction.getQuantity();
        if (finalBalance >= 0) {
            Storage.reports.put(transaction.getFruit(),
                    getBalance(transaction) - transaction.getQuantity());
        } else {
            throw new RuntimeException("It's not possible make purchase = "
                    + transaction.getQuantity()
                    + ", due insufficient balance = " + getBalance(transaction));
        }
    }

    private int getBalance(FruitTransaction transaction) {
        return Storage.reports.get(transaction.getFruit());
    }
}
