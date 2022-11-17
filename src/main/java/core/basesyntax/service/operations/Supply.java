package core.basesyntax.service.operations;

import static core.basesyntax.db.Storage.storage;

public class Supply implements IOperation {
    @Override
    public void makeOperation(String key, Integer value) {
        storage.put(key, storage.get(key) + value);
    }
}
