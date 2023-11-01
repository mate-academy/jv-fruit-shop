package core.basesyntax.handlers;

import core.basesyntax.db.Storage;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handle(String fruit,int quantity) {
        Storage.fruits.put(fruit, quantity);
    }
}
