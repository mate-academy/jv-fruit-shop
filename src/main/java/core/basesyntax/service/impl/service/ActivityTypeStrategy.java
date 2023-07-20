package core.basesyntax.service.impl.service;

import core.basesyntax.strategy.ActivityTypeHandler;

public interface ActivityTypeStrategy {
    ActivityTypeHandler get(String code);
}
