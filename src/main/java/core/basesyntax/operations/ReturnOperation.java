package core.basesyntax.operations;

import core.basesyntax.db.Storage;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(String fruit, int quantity, Storage storage) {
        storage.getStorage().put(fruit, storage.getStorage().get(fruit) + quantity);
    }
}
