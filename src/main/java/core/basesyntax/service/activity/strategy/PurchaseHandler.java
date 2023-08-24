package core.basesyntax.service.activity.strategy;

import core.basesyntax.db.FruitsDb;
import core.basesyntax.model.FruitActivity;
import core.basesyntax.service.exceptions.InvalidFruitsQuantityException;

public class PurchaseHandler implements ActivityHandler {

    @Override
    public void processActivity(FruitActivity fruitActivity) {
        validateActivity(fruitActivity);
        String fruitName = fruitActivity.getFruitName();
        Integer quantity = fruitActivity.getQuantity();
        if (quantity > FruitsDb.fruitDb.get(fruitName)) {
            throw new InvalidFruitsQuantityException(
                    "Purchase quantity is bigger than available quantity. "
                            + "Purchase quantity is " + FruitsDb.fruitDb.get(fruitName)
                            + "Available quantity is " + quantity + ";");
        }
        FruitsDb.fruitDb.put(fruitName,
                FruitsDb.fruitDb.get(fruitName) - quantity);
    }
}
