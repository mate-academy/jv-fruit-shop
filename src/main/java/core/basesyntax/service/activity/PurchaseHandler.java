package core.basesyntax.service.activity;

import core.basesyntax.db.FruitsDb;
import core.basesyntax.model.Activity;
import core.basesyntax.service.exceptions.InvalidQuantityException;

public class PurchaseHandler implements ActivityHandler {

    @Override
    public void processActivity(Activity activity) {
        String fruitName = activity.getFruitName();
        Integer quantity = activity.getQuantity();
        if (quantity > FruitsDb.fruitDb.get(fruitName)) {
            throw new InvalidQuantityException();
        }
        FruitsDb.fruitDb.put(fruitName,
                FruitsDb.fruitDb.get(fruitName) - quantity);
    }
}
