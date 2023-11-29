package core.basesyntax.strategy;

import core.basesyntax.action.Action;
import core.basesyntax.action.ActionHandler;
import java.util.Map;

public class ActionStrategyImpl implements ActionStrategy {
    private final Map<Action, ActionHandler> actionHandlersMap;

    public ActionStrategyImpl(Map<Action, ActionHandler> actionHandlersMap) {
        this.actionHandlersMap = actionHandlersMap;
    }

    @Override
    public ActionHandler get(Action action) {
        return actionHandlersMap.get(action);
    }
}
