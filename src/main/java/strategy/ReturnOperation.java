package strategy;

import db.Storage;
import model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int currentQuantity = Storage.getQuantity(transaction.getFruit());
        Storage.setQuantity(transaction.getFruit(), currentQuantity + transaction.getQuantity());
    }
}
