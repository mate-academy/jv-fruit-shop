package core.basesyntax.strategy;

import core.basesyntax.model.Action;
import core.basesyntax.service.ActionHandler;

public interface ActionStrategy {
    ActionHandler getHandler(Action operation);
}
