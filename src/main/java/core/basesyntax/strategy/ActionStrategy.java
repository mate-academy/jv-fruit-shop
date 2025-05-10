package core.basesyntax.strategy;

import core.basesyntax.action.Action;
import core.basesyntax.action.ActionHandler;

public interface ActionStrategy {
    ActionHandler get(Action action);
}
