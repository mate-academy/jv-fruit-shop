package core.basesyntax.service.strategy;

import core.basesyntax.constants.Activity;

public interface ActivityTypeStrategy {
    public Activity get(String csvActivity);
}
