package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        int currentAmount = Storage.fruitModels.getOrDefault(fruit, 0);
        Storage.fruitModels.put(fruit,currentAmount + quantity);

    }
}
