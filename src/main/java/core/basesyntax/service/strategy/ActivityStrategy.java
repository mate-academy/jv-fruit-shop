package core.basesyntax.service.strategy;

import core.basesyntax.service.activity.ActivityHandler;

public interface ActivityStrategy {
    ActivityHandler get(String activity);
}
