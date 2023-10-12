package service.activities;

import db.FruitShopStorage;
import model.FruitTransaction;

public class SupplyTransactionHandler implements TransactionHandler {
    @Override
    public void executeTransaction(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        int quantitySupply = FruitShopStorage.fruitShop.get(fruit);
        FruitShopStorage.fruitShop.put(fruit,quantitySupply + quantity);
    }
}
