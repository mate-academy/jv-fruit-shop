package core.basesyntax.service.operations;

import static core.basesyntax.db.Storage.storage;

public class SupplyOperationHanler implements OperationHandler {
    @Override
    public void handle(String key, Integer value) {
        storage.put(key, (storage.get(key) != null ? storage.get(key) : 0) + value);
    }
}
