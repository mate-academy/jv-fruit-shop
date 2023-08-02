package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int quantity = transaction.getQuantity();
        if (FruitStorage.getFruit(fruitName).isPresent()) {
            String fruit = FruitStorage.getFruit(fruitName).get();
            int updatedQuantity = FruitStorage.getFruits().get(fruit) - quantity;
            if (updatedQuantity < 0) {
                throw new RuntimeException("Invalid fruit "
                        + "quantity after purchase: " + fruitName);
            }
            FruitStorage.updateFruitQuantity(fruitName, updatedQuantity);
        }
    }
}
