package core.basesyntax.strategy;

import core.basesyntax.action.ActionHandler;
import core.basesyntax.action.Actions;

public interface ActionStrategy {
    ActionHandler get(Actions action);
}
