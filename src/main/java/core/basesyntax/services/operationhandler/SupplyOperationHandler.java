package core.basesyntax.services.operationhandler;

import core.basesyntax.db.DB;

import java.security.InvalidParameterException;

public class SupplyOperationHandler implements IOperationHandler {
    @Override
    public void handleOperation(String fruit, int quantity) {
        if (quantity < 0) {
            throw new InvalidParameterException("Supply quantity cannot be negative");
        }

        Integer prevFruitQuantity = DB.getFruitsDB().get(fruit);
        Integer newFruitQuantity = prevFruitQuantity != null
                ? prevFruitQuantity + quantity
                : quantity;

        DB.getFruitsDB().put(fruit, newFruitQuantity);
    }
}
