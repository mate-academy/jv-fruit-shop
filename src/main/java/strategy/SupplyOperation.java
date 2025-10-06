package strategy;

import db.Storage;
import model.FruitTransaction;

public class SupplyOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction null");
        }

        Storage.addQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
