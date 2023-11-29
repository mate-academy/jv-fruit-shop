package core.basesyntax.strategy;

import core.basesyntax.action.ActionHandler;
import core.basesyntax.action.Action;

public interface ActionStrategy {
    ActionHandler get(Action action);
}
