package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandlerImpl implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction, FruitStorage fruitStorage) {
        String fruitName = transaction.getFruit();
        int quantity = transaction.getQuantity();

        try {
            Fruit existingFruit = fruitStorage.getFruit(fruitName);
            if (existingFruit == null) {
                fruitStorage.addFruit(new Fruit(fruitName, quantity));
            } else {
                existingFruit.setQuantity(existingFruit.getQuantity() + quantity);
            }
        } catch (Exception e) {
            throw new RuntimeException("Supply operation failed!");
        }
    }
}

