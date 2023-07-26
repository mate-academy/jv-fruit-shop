package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int quantity = transaction.getQuantity();

        FruitTransaction fruit = FruitStorage.getFruit(fruitName).get();
        if (fruit != null) {
            int updatedQuantity = fruit.getQuantity() - quantity;
            if (updatedQuantity < 0) {
                throw new RuntimeException("Invalid fruit quantity after purchase: " + fruitName);
            }
            fruit.setQuantity(updatedQuantity);
        } else {
            throw new RuntimeException("core.basesyntax.model.Fruit not found: " + fruitName);
        }
    }
}
