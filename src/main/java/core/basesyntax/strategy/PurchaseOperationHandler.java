package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void processCommand(String[] data) {
        for (String key : Storage.Storage.keySet()) {
            Integer value = Storage.Storage.get(key);
            if (key.equals(data[FRUIT])) {
                value -= Integer.parseInt(data[QUANTITY]);
            }
            Storage.Storage.replace(key, value);
        }
    }
}
