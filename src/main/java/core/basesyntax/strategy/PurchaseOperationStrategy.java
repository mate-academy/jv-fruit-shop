package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationStrategy implements OperationStrategy {
    @Override
    public void operationStrategy(FruitTransaction transaction, FruitStorage fruitStorage) {
        String fruitName = transaction.getFruit();
        int quantity = transaction.getQuantity();

        Fruit fruit = fruitStorage.getFruit(fruitName);
        if (fruit != null) {
            int updatedQuantity = fruit.getQuantity() - quantity;
            if (updatedQuantity >= 0) {
                fruit.setQuantity(updatedQuantity);
            } else {
                throw new RuntimeException("Invalid fruit quantity after purchase: " + fruitName);
            }
        } else {
            throw new RuntimeException("Fruit not found: " + fruitName);
        }
    }
}
