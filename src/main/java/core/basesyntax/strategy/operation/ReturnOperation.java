package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;

public class ReturnOperation implements OperationHandler {
    @Override
    public void getOperation(String name, int amount) {
        int currentAmount = 0;
        if (Storage.fruits.containsKey(name)) {
            currentAmount = Storage.fruits.get(name);
        }
        currentAmount += amount;
        Storage.fruits.put(name, currentAmount);
    }
}
