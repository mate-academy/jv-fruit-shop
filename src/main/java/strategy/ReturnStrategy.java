package strategy;

import model.FruitStorage;
import model.FruitTransaction;

public class ReturnStrategy implements TransactionStrategy {
    @Override
    public void apply(FruitStorage fruitStorage, FruitTransaction transaction) {
        fruitStorage.getFruitInventory().merge(transaction.getFruit(),
                transaction.getQuantity(), Integer::sum);
    }
}
