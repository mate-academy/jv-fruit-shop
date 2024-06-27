package strategy.handlers;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class BalanceHandler implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        validateTransaction(transaction);
        Storage.addFruit(transaction.getFruit(), transaction.getQuantity());
    }

    private void validateTransaction(FruitTransaction transaction) {
        if (transaction.getQuantity() < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative: "
                    + transaction.getQuantity());
        }
    }
}
