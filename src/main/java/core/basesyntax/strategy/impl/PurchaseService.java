package core.basesyntax.strategy.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.ActivityService;

public class PurchaseService implements ActivityService {

    @Override
    public void releaseActivity(Fruit fruit, int count) {
        if (fruit.getCount() < count) {
            return;
        }
        fruit.setCount(fruit.getCount() - count);
    }
}
