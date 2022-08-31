package core.basesyntax.service.strategy;

import core.basesyntax.model.TypeActivity;
import core.basesyntax.service.strategy.handlers.ActivityHandler;

public interface TypeActivityStrategy {
    ActivityHandler getHandlerByTypeActivity(TypeActivity typeActivity);
}
