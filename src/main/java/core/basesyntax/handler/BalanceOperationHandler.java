package core.basesyntax.handler;

import core.basesyntax.db.Storage;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public boolean handle(String fruit, int quantity) {
        Storage.FRUITS.put(fruit, quantity);
        return true;
    }
}
