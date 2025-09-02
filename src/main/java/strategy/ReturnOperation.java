package strategy;

import db.Storage;
import model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int currentQuantity = Storage.getQuantity(transaction.getFruit());
        Storage.add(transaction.getFruit(), currentQuantity + transaction.getQuantity());
    }
}
