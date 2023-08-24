package core.basesyntax.service.activity.strategy;

import core.basesyntax.db.FruitsDb;
import core.basesyntax.model.FruitActivity;

public class SupplyHandler implements ActivityHandler {

    @Override
    public void processActivity(FruitActivity fruitActivity) {
        validateActivity(fruitActivity);
        String fruitName = fruitActivity.getFruitName();
        Integer quantity = fruitActivity.getQuantity();
        FruitsDb.fruitDb.put(fruitName,
                FruitsDb.fruitDb.get(fruitName) + quantity);
    }
}
