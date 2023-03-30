package strategy;

import static db.Storage.fruits;

import db.Storage;
import model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction transaction) {
        int quantityPurchase = Storage.fruits
                .get(transaction.getFruit()) - transaction.getQuantity();
        if (quantityPurchase < 0) {
            throw new RuntimeException("For purchase don't enough " + (-quantityPurchase)
                    + " \"" + transaction.getFruit() + "\" in the storage");
        }
        fruits.put(transaction.getFruit(), quantityPurchase);
    }
}
