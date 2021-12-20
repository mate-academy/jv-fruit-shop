package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.activity.Activity;

public interface ActivityStrategy {
    Activity get(Fruit.Type type);
}
