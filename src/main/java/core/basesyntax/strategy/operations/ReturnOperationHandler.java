package core.basesyntax.strategy.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        ReturnOperationHandler.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }

    private static void add(String name, int quantity) {
        if (Storage.fruits.containsKey(name)) {
            quantity += Storage.fruits.get(name);
        }
        Storage.fruits.put(name, quantity);
    }
}
