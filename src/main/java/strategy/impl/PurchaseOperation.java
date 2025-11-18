package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        Integer stockQuantity = Storage.getQuantity(fruit);
        Integer purchaseQuantity = transaction.getQuantity();
        if (stockQuantity >= purchaseQuantity) {
            Integer newStock = stockQuantity - transaction.getQuantity();
            Storage.put(fruit, newStock);
        } else {
            throw new RuntimeException(
                    "The quantity of required fruit in stock is less than " + purchaseQuantity);
        }
    }
}
