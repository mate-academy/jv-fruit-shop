package core.basesyntax.strategy.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.ActivityService;

public class ReturnService implements ActivityService {

    @Override
    public void releaseActivity(Fruit fruit, int count) {
        fruit.setCount(fruit.getCount() + count);
    }
}
