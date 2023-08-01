package core.basesyntax.services.impl;

import core.basesyntax.model.Task;
import core.basesyntax.services.ActionStrategy;
import core.basesyntax.services.actions.ActionHandler;
import java.util.Map;

public class ActionStrategyImpl implements ActionStrategy {
    private Map<Task.ActionType, ActionHandler> actionHandlerMap;

    public ActionStrategyImpl(Map<Task.ActionType, ActionHandler> actionHandlerMap) {
        this.actionHandlerMap = actionHandlerMap;
    }

    @Override
    public ActionHandler get(Task.ActionType type) {
        return actionHandlerMap.get(type);
    }
}
