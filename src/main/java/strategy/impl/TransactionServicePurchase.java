package strategy.impl;

import db.FruitStorage;
import model.FruitTransaction;
import strategy.TransactionService;

public class TransactionServicePurchase implements TransactionService {
    @Override
    public void applyTransaction(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int currentQuantity = FruitStorage.storage.getOrDefault(fruit, 0);
        int purchasedQuantity = transaction.getQuantity();
        if (purchasedQuantity > currentQuantity) {
            throw new RuntimeException("Purchase quantity of " + fruit
                    + " is " + purchasedQuantity + ", but balance is " + currentQuantity + "!");
        }
        FruitStorage.storage.put(fruit, currentQuantity - purchasedQuantity);
    }
}
