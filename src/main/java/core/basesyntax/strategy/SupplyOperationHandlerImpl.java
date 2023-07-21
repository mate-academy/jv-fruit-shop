package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandlerImpl implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int quantity = transaction.getQuantity();
        FruitTransaction existingFruit = FruitStorage.getFruit(fruitName);
        if (existingFruit == null) {
            FruitStorage.addFruit(new FruitTransaction(fruitName, quantity));
        } else {
            existingFruit.setQuantity(existingFruit.getQuantity() + quantity);
        }
    }
}
