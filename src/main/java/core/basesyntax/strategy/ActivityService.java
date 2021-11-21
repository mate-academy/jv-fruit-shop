package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;

public interface ActivityService {
    void releaseActivity(Fruit fruit, int count);
}
