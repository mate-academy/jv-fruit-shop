package core.basesyntax.strategy;

import core.basesyntax.model.Action;
import core.basesyntax.service.ActionHandler;
import java.util.Map;

public class ActionStrategyImpl implements ActionStrategy {
    private final Map<Action, ActionHandler> handlers;

    public ActionStrategyImpl(Map<Action, ActionHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public ActionHandler getHandler(Action action) {
        return handlers.get(action);
    }
}
