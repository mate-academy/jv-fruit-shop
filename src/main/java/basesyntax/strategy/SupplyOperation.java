package basesyntax.strategy;

import basesyntax.db.Storage;
import basesyntax.model.FruitTransaction;
import basesyntax.service.OperationHandler;

public class SupplyOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        Storage.getFruits().put(
                fruit,
                Storage.getFruits().getOrDefault(fruit, 0) + quantity
        );
    }
}
