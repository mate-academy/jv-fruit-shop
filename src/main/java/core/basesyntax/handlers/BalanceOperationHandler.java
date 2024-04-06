package core.basesyntax.handlers;

import core.basesyntax.database.DataBase;
import core.basesyntax.service.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(String fruit, int quantity) {
        DataBase.mapDb.put(fruit, quantity);
    }
}
