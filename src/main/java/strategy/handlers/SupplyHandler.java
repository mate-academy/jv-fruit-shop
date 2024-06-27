package strategy.handlers;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class SupplyHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction cannot be null");
        }

        if (transaction.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be a positive number");
        }

        Storage.addFruit(transaction.getFruit(), transaction.getQuantity());
    }
}
