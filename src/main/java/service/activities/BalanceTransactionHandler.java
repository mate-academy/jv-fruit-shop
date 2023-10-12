package service.activities;

import db.FruitShopStorage;
import model.FruitTransaction;

public class BalanceTransactionHandler implements TransactionHandler {
    private final QuantityVerifier quantityVerifier = new QuantityVerifierImpl();

    @Override
    public void executeTransaction(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        quantityVerifier.quantityVerify(quantity, fruit);
        FruitShopStorage.fruitShop.put(fruit, quantity);
    }
}

