package core.basesyntax.strategy.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

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
