package core.basesyntax.service.operations;

import core.basesyntax.dao.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class BuyOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        Integer quantityToBuy = transaction.getQuantity();
        Integer currentQuantity = FruitStorage.storage.getOrDefault(fruit, 0);
        if (currentQuantity < quantityToBuy) {
            throw new RuntimeException("Not enough " + fruit + " in stock. Available: "
                    + currentQuantity);
        }
        FruitStorage.storage.put(fruit, currentQuantity - quantityToBuy);
    }
}
