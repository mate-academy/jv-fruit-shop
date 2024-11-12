package core.basesyntax.services.operationhandler;

import core.basesyntax.db.DB;

import java.security.InvalidParameterException;

public class PurchaseOperationHandler implements IOperationHandler {
    @Override
    public void handleOperation(String fruit, int quantity) {
        if (quantity < 0) {
            throw new InvalidParameterException("Purchase quantity cannot be negative");
        }

        Integer fruitQuantity = DB.getFruitsDB().get(fruit);

        if (fruitQuantity == null) {
            throw new InvalidParameterException("This fruit does not exist in the shop");
        }

        if (fruitQuantity < quantity) {
            throw new InvalidParameterException(
                    "Don't have some many fruits. Reduce your appetite"
            );
        }

        DB.getFruitsDB().replace(fruit, fruitQuantity - quantity);
    }
}
