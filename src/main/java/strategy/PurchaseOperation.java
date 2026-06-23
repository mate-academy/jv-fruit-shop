package strategy;

import db.Storage;
import model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int currentQuantity = Storage.getQuantity(transaction.getFruit());
        int newQuantity = currentQuantity - transaction.getQuantity();
        if (newQuantity < 0) {
            throw new RuntimeException("Not enough fruit to sell. Fruit: " + transaction.getFruit()
                    + ", available: " + currentQuantity + ", requested: " + transaction.getQuantity());
        }
        Storage.setQuantity(transaction.getFruit(), newQuantity);
    }
}
