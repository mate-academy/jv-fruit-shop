package core.basesyntax.strategy.implementation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;

public class PurchaseOperationStrategy implements OperationStrategy {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        Integer quantity = fruitTransaction.getQuantity();
        if (fruit == null || quantity < 0) {
            throw new RuntimeException("Invalid data inside "
                    + "fruit transaction in the balance operation");
        }
        Integer amount = FruitStorage.get(fruit);
        if (amount == null) {
            FruitStorage.put(fruit, quantity);
            return;
        }
        if (quantity > amount) {
            throw new RuntimeException("You want to buy " + quantity
                    + " fruits, but there are only " + amount + " fruits in the store");
        }
        FruitStorage.put(fruit, amount - quantity);
    }
}
