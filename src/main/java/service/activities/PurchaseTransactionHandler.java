package service.activities;

import db.FruitShopStorage;
import model.FruitTransaction;

public class PurchaseTransactionHandler implements TransactionHandler {
    QuantityVerifier quantityVerifier = new QuantityVerifierImpl();
    @Override
    public void executeTransaction(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        quantityVerifier.quantityVerify(quantity, fruit);
        int quantityPurchase = FruitShopStorage.fruitShop.get(fruit);
        int quantityNew = quantityPurchase - quantity;
        quantityVerifier.quantityVerify(quantityNew, fruit);
        FruitShopStorage.fruitShop.put(fruit, quantityNew);
    }
}
