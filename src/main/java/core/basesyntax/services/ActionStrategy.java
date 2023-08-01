package core.basesyntax.services;

import core.basesyntax.model.Task;
import core.basesyntax.services.actions.ActionHandler;

public interface ActionStrategy {
    ActionHandler get(Task.ActionType type);
}
