package strategy;

import db.Storage;
import model.FruitTransaction;

public class BalanceOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction null");
        }
        Storage.setQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
