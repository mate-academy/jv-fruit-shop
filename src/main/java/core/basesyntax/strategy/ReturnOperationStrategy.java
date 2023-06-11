package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationStrategy implements OperationStrategy {
    @Override
    public void operationStrategy(FruitTransaction transaction, FruitStorage fruitStorage) {
        String fruitName = transaction.getFruit();
        int quantity = transaction.getQuantity();

        Fruit fruit = fruitStorage.getFruit(fruitName);
        if (fruit != null) {
            fruit.setQuantity(fruit.getQuantity() + quantity);
        } else {
            throw new RuntimeException("Fruit not found: " + fruitName);
        }
    }
}
