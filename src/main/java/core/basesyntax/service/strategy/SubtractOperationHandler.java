package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.DailyActivity;
import core.basesyntax.model.Fruit;

public class SubtractOperationHandler implements OperationHandler {
    @Override
    public boolean operation(DailyActivity dailyActivity) {
        Fruit fruit = new Fruit(dailyActivity.getFruitName());
        int amount = dailyActivity.getAmount();
        int amountPrev = Storage.storage.get(fruit);
        if (amountPrev < amount) {
            throw new RuntimeException("There isn`t enough fruit for this operation");
        }

        Storage.storage.put(fruit, amountPrev - amount);
        return true;
    }
}
