package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void doOperation(String fruit, int numbers) {
        Storage.storage.put(fruit, Storage.storage.get(fruit) + numbers);
    }
}
