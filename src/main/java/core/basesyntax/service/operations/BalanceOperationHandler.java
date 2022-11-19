package core.basesyntax.service.operations;

import static core.basesyntax.db.Storage.storage;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handle(String key, Integer value) {
        storage.put(key, value);
    }
}
