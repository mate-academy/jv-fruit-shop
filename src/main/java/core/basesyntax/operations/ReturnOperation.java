package core.basesyntax.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruits = transaction.getFruit();
        var quantity = transaction.getQuantity();
        var currentQuantity = Storage.fruits.getOrDefault(fruits, 0);
        Storage.fruits.put(fruits, currentQuantity + quantity);
    }
}
