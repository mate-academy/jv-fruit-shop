package core.basesyntax.strategy;

import core.basesyntax.service.db.Database;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void processCommand(String[] data) {
        Database.database.put(data[FRUIT], Integer.valueOf(data[QUANTITY]));
    }
}
