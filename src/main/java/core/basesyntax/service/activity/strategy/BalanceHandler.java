package core.basesyntax.service.activity.strategy;

import core.basesyntax.db.FruitsDb;
import core.basesyntax.model.FruitActivity;

public class BalanceHandler implements ActivityHandler {

    @Override
    public void processActivity(FruitActivity fruitActivity) {
        validateActivity(fruitActivity);
        FruitsDb.fruitDb.put(fruitActivity.getFruitName(), fruitActivity.getQuantity());
    }
}
