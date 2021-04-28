package core.basesyntax.service;

import core.basesyntax.service.handler.ActionHandler;
import java.util.Map;
import java.util.Optional;

public class ActionStrategyImpl implements ActionStrategy {
    private Map<String, ActionHandler> actionHandlerMap;

    public ActionStrategyImpl(Map<String, ActionHandler> actionHandlerMap) {
        this.actionHandlerMap = actionHandlerMap;
    }

    @Override
    public Optional<ActionHandler> get(String action) {
        return Optional.ofNullable(actionHandlerMap.get(action));
    }
}
