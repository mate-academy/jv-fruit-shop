package service.activities;

import db.FruitShopStorage;
import model.FruitTransaction;

public class PurchaseTransactionHandler implements TransactionHandler {
    @Override
    public void executeTransaction(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        if (quantity < 0) {
            throw new RuntimeException("Initial quantity cannot be negative for fruit: " + fruit);
        }
        int quantityPurchase = FruitShopStorage.fruitShop.get(fruit);
        FruitShopStorage.fruitShop.put(fruit, quantityPurchase - quantity);
    }
}
