package core.basesyntax.strategy.handlerimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction) {
        int quantity = fruitTransaction.getQuantity();
        String fruit = fruitTransaction.getFruit();
        boolean isInvalid = !Storage.fruitStorage.containsKey(fruit)
                || Storage.fruitStorage.get(fruit) - quantity < 0;
        if (isInvalid) {
            throw new RuntimeException("Not enough quantity of fruit " + fruit);
        }
        Storage.fruitStorage.put(fruit, Storage.fruitStorage.get(fruit) - quantity);
    }
}
