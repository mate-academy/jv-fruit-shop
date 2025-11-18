package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class ReturnOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        Integer stockQuantity = Storage.getQuantity(fruit);
        Integer purchaseQuantity = transaction.getQuantity();
        Integer newStock = stockQuantity + purchaseQuantity;
        Storage.put(fruit, newStock);
    }
}
