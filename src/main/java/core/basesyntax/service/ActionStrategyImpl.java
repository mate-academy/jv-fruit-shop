package core.basesyntax.service;

import core.basesyntax.model.Operation;
import core.basesyntax.service.action.ActionHandler;
import java.util.Map;

public class ActionStrategyImpl implements ActionStrategy {
    private Map<Operation, ActionHandler> actionHandlerMap;
    private ActionStrategy strategy;

    public ActionStrategyImpl(Map<Operation, ActionHandler> actionHandlerMap) {
        this.actionHandlerMap = actionHandlerMap;
    }

    @Override
    public ActionHandler get(Operation operation) {
        return actionHandlerMap.get(operation);
    }
}
