package strategy;

import model.FruitTransaction;

public class PurchaseStrategy implements TransactionStrategy {
    @Override
    public void apply(FruitTransaction fruit, FruitTransaction transaction) {
        fruit.setQuantity(Math.max(0, fruit.getQuantity() - transaction.getQuantity()));
    }
}
