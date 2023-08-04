package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandlerImpl implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int quantity = transaction.getQuantity();

        if (!FruitStorage.isFruitPresent(fruitName)) {
            throw new RuntimeException("Fruit not found: " + fruitName);
        }
        FruitStorage.setQuantity(fruitName, FruitStorage.getQuantity(fruitName) + quantity);
    }
}
