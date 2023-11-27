package core.basesyntax.strategy;

import core.basesyntax.action.ActionHandler;
import core.basesyntax.action.Actions;
import java.util.Map;

public class ActionStrategyImpl implements ActionStrategy {
    private final Map<Actions, ActionHandler> actionHandlersMap;

    public ActionStrategyImpl(Map<Actions, ActionHandler> actionHandlersMap) {
        this.actionHandlersMap = actionHandlersMap;
    }

    @Override
    public ActionHandler get(Actions action) {
        return actionHandlersMap.get(action);
    }
}
