package core.basesyntax.service;

import core.basesyntax.model.FruitActivity;
import core.basesyntax.service.activity.strategy.ActivityHandler;

public interface ActivityStrategy {
    ActivityHandler get(FruitActivity.Type type);
}
