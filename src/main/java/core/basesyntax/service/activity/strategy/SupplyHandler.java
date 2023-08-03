package core.basesyntax.service.activity.strategy;

import core.basesyntax.db.FruitsDb;
import core.basesyntax.model.Activity;

public class SupplyHandler implements ActivityHandler {

    @Override
    public void processActivity(Activity activity) {
        validateActivity(activity);
        String fruitName = activity.getFruitName();
        Integer quantity = activity.getQuantity();
        FruitsDb.fruitDb.put(fruitName,
                FruitsDb.fruitDb.get(fruitName) + quantity);
    }
}
