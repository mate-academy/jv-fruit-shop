package strategy.impl;

import db.FruitStorage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int balance = FruitStorage.fruits.get(transaction.getFruit());
        int purchaseQuantity = transaction.getQuantity();
        if (purchaseQuantity > balance) {
            throw new RuntimeException("Purchase quantity can't be bigger than balance, "
                    + "balance: " + balance + ", purchase quantity: " + purchaseQuantity);
        }
        FruitStorage.fruits.put(transaction.getFruit(), balance - purchaseQuantity);
    }
}
