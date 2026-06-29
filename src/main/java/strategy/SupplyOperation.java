package strategy;

import db.Storage;
import model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int currentQuantity = Storage.getQuantity(fruit);
        Storage.updateQuantity(fruit, currentQuantity + transaction.getQuantity());
    }
}



