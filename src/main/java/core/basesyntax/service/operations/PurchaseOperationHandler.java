package core.basesyntax.service.operations;

import static core.basesyntax.db.Storage.storage;

public class PurchaseOperationHandler implements IOperationHandler {
    @Override
    public void handle(String key, Integer value) {
        storage.put(key, storage.get(key) - value);
    }
}
