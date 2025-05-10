package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class BalanceOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("Balance can't be negative, in file balance = "
                    + transaction.getQuantity());
        }
        Storage.reports.put(transaction.getFruit(), transaction.getQuantity());
    }
}
