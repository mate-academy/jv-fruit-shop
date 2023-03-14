package core.basesyntax.strategy.implementation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;

public class BalanceOperationStrategy implements OperationStrategy {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        Integer quantity = fruitTransaction.getQuantity();
        if (fruit == null || quantity < 0) {
            throw new RuntimeException("Invalid data inside fruit "
                    + "transaction in the balance operation");
        }
        Integer amount = FruitStorage.get(fruit);
        if (amount == null) {
            FruitStorage.put(fruit, quantity);
        } else {
            FruitStorage.put(fruit, amount + quantity);
        }
    }
}
