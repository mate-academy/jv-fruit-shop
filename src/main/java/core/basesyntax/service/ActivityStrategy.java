package core.basesyntax.service;

import core.basesyntax.model.TypeActivity;
import core.basesyntax.service.strategy.ActivityHandler;

public interface ActivityStrategy {
    ActivityHandler get(TypeActivity typeActivity);
}
