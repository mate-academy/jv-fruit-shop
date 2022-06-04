package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.action.ActionHandler;

public interface ActionStrategy {
    ActionHandler get(Operation operation);
}
