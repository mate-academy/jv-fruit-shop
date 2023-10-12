package service.activities;

import db.FruitShopStorage;
import model.FruitTransaction;

public class ReturnTransactionHandler implements TransactionHandler {
    @Override
    public void executeTransaction(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        int quantityReturn = FruitShopStorage.fruitShop.get(fruit);
        FruitShopStorage.fruitShop.put(fruit, quantityReturn + quantity);
    }
}
