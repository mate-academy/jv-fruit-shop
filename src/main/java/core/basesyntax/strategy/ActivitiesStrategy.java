package core.basesyntax.strategy;

import core.basesyntax.constants.Activity;
import core.basesyntax.strategy.handlers.ActivityHandler;

public interface ActivitiesStrategy {
    public ActivityHandler get(Activity activity);
}
