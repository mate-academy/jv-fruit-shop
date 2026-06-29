package strategy;

import db.Storage;
import model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int currentQuantity = Storage.getQuantity(fruit);
        Storage.updateQuantity(fruit, currentQuantity + transaction.getQuantity());
    }
}


