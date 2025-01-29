package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;
import core.basesyntax.data.Storage;

public class ReturnOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        Storage.fruitStorage.put(
                fruit,
                Storage.fruitStorage.getOrDefault(fruit, 0) + quantity
        );
    }
}
