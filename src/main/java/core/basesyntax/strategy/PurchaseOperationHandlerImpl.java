package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction) {
        //FruitStorage fruitStorage = new FruitStorage();
        String fruitName = transaction.getFruit();
        int quantity = transaction.getQuantity();

        FruitTransaction fruit = FruitStorage.getFruit(fruitName);
        if (fruit != null) {
            int updatedQuantity = fruit.getQuantity() - quantity;
            if (updatedQuantity >= 0) {
                fruit.setQuantity(updatedQuantity);
            } else {
                throw new RuntimeException("Invalid fruit quantity after purchase: " + fruitName);
            }
        } else {
            throw new RuntimeException("core.basesyntax.model.Fruit not found: " + fruitName);
        }
    }
}

