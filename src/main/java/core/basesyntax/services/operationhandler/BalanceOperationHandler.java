package core.basesyntax.services.operationhandler;

import core.basesyntax.db.DB;

import java.security.InvalidParameterException;

public class BalanceOperationHandler implements IOperationHandler {
    @Override
    public void handleOperation(String fruit, int quantity) {
        if (quantity < 0) {
            throw new InvalidParameterException("Initial fruit quantity cannot be negative");
        }

        DB.fruitsDB.put(fruit, quantity);
    }
}
