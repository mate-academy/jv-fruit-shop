package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.activity.ActivityHandler;

public interface ActivityStrategy {
    ActivityHandler get(Fruit.ACTIVITY activity);
}
