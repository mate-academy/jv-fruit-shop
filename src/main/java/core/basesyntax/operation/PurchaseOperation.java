package core.basesyntax.operation;

import core.basesyntax.base.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int currentQuantity = Storage.fruitStorage.getOrDefault(fruit, 0);
        if (currentQuantity < transaction.getQuantity()) {
            throw new RuntimeException("Not enough " + fruit + " in stock!");
        }
        Storage.fruitStorage.put(fruit, currentQuantity - transaction.getQuantity());
    }
}
