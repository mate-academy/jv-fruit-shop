package core.basesyntax.services.operationhandler;

import core.basesyntax.db.DB;

import java.security.InvalidParameterException;

public class ReturnOperationHandler implements IOperationHandler {
    @Override
    public void handleOperation(String fruit, int quantity) {
        if (quantity < 0) {
            throw new InvalidParameterException("Куегкт quantity cannot be negative");
        }

        Integer fruitQuantity = DB.getFruitsDB().get(fruit);

        if (fruitQuantity == null) {
            throw new InvalidParameterException("This fruit does not exist in the shop");
        }

        DB.getFruitsDB().replace(fruit, fruitQuantity + quantity);
    }
}
