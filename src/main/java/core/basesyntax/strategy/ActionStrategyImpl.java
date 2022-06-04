package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.action.ActionHandler;
import java.util.Map;

public class ActionStrategyImpl implements ActionStrategy {
    private final Map<Operation, ActionHandler> actionHandlerMap;

    public ActionStrategyImpl(Map<Operation, ActionHandler> actionHandlerMap) {
        this.actionHandlerMap = actionHandlerMap;
    }

    @Override
    public ActionHandler get(Operation operation) {
        ActionHandler actionHandler = actionHandlerMap.get(operation);
        if (actionHandler == null) {
            throw new RuntimeException(
                    String.format("I don't now how to work with '%s' operation", operation));
        }
        return actionHandler;
    }
}
