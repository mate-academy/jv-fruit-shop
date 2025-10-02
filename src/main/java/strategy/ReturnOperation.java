package strategy;

import db.Storage;
import model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Storage.addQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
