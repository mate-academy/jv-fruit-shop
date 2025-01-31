package strategy;

import model.FruitTransaction;

public class ReturnStrategy implements TransactionStrategy {
    @Override
    public void apply(FruitTransaction fruit, FruitTransaction transaction) {
        fruit.setQuantity(fruit.getQuantity() + transaction.getQuantity());
    }
}
