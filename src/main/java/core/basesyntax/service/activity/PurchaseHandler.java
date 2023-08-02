package core.basesyntax.service.activity;

import core.basesyntax.db.FruitsDb;
import core.basesyntax.model.Activity;

public class PurchaseHandler implements ActivityHandler {

    @Override
    public void processActivity(Activity activity) {
        String fruitName = activity.getFruitName();
        Integer quantity = activity.getQuantity();
        FruitsDb.fruitDb.put(fruitName,
                FruitsDb.fruitDb.get(fruitName) - quantity);
    }
}
