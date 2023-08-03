package core.basesyntax.service.activity.strategy;

import core.basesyntax.db.FruitsDb;
import core.basesyntax.model.Activity;
import core.basesyntax.service.exceptions.InvalidQuantityException;

public class PurchaseHandler implements ActivityHandler {

    @Override
    public void processActivity(Activity activity) {
        validateActivity(activity);
        String fruitName = activity.getFruitName();
        Integer quantity = activity.getQuantity();
        if (quantity > FruitsDb.fruitDb.get(fruitName)) {
            throw new InvalidQuantityException(
                    "Purchase quantity is bigger than available quantity. "
                            + "Purchase quantity is " + FruitsDb.fruitDb.get(fruitName)
                            + "Available quantity is " + quantity + ";");
        }
        FruitsDb.fruitDb.put(fruitName,
                FruitsDb.fruitDb.get(fruitName) - quantity);
    }
}
