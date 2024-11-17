package core.basesyntax.service;

import core.basesyntax.model.Operation;
import core.basesyntax.service.action.ActionHandler;

public interface ActionStrategy {
    ActionHandler get(Operation operation);
}
