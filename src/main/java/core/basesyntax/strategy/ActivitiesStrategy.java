package core.basesyntax.strategy;

import core.basesyntax.strategy.handlers.ActivityHandler;

public interface ActivitiesStrategy {
    ActivityHandler get(String activity);
}
