package core.basesyntax.operations;

import core.basesyntax.db.Storage;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(String fruit, int quantity) {
        Storage.storage.put(fruit, Storage.storage.get(fruit) + quantity);
    }
}
