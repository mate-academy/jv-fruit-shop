package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;

public class ReturnHandler implements OperationHandler {
    @Override
    public int operate(String fruit, int number) {
        return Storage.storage.get(fruit) + number;
    }
}
