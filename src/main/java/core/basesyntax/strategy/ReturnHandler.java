package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class ReturnHandler implements OperationHandler {
    @Override
    public void execute(String fruit, int quantity) {
        Storage.STORAGE.put(fruit, Storage.STORAGE.get(fruit) + quantity);
    }
}
