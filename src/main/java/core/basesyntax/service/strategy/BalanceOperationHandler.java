package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.DailyActivity;
import core.basesyntax.model.Fruit;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public boolean operation(DailyActivity dailyActivity) {
        String fruitName = dailyActivity.getFruitName();
        int amount = dailyActivity.getAmount();
        Storage.storage.put(new Fruit(fruitName), amount);
        return true;
    }
}
