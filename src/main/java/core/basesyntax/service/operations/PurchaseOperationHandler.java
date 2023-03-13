package core.basesyntax.service.operations;

import static core.basesyntax.db.Storage.storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(String key, Integer value) {
        if (storage.containsKey(key) && storage.get(key) >= value) {
            storage.put(key, storage.get(key) - value);
        } else {
            System.out.println("Mission impossible");
        }
    }
}
