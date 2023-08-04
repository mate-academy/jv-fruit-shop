package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int quantity = transaction.getQuantity();
        if (FruitStorage.isFruitPresent(fruitName)) {
            int updatedQuantity = FruitStorage.getFruits().get(fruitName) - quantity;
            if (updatedQuantity < 0) {
                throw new RuntimeException("Invalid fruit "
                        + "quantity after purchase: " + fruitName);
            }
            FruitStorage.updateFruitQuantity(fruitName, updatedQuantity);
        }
    }
}
