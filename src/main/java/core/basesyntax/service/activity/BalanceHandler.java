package core.basesyntax.service.activity;

import core.basesyntax.db.FruitsDb;
import core.basesyntax.model.Activity;

public class BalanceHandler implements ActivityHandler {

    @Override
    public void processActivity(Activity activity) {
        FruitsDb.fruitDb.put(activity.getFruitName(), activity.getQuantity());

    }
}
