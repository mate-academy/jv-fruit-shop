package core.basesyntax.strategy;

import core.basesyntax.strategy.activity.ActivityHandler;

public interface ActivityStrategy {
    ActivityHandler get(String operation);
}
