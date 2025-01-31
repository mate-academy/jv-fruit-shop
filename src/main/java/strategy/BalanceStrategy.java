package strategy;

import model.FruitTransaction;

public class BalanceStrategy implements TransactionStrategy{
    @Override
    public void apply(FruitTransaction fruit, FruitTransaction transaction) {
        fruit.setQuantity(transaction.getQuantity());
    }
}
