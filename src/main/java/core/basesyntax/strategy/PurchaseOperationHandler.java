package core.basesyntax.strategy;

import core.basesyntax.service.db.Database;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void processCommand(String[] data) {
        for (String key : Database.database.keySet()) {
            Integer value = Database.database.get(key);
            if (key.equals(data[FRUIT])) {
                value -= Integer.parseInt(data[QUANTITY]);
            }
            Database.database.replace(key, value);
        }
    }
}
