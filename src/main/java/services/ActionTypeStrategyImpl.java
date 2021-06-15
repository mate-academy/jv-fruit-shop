package services;

import java.util.Map;
import services.actions.ActionHandler;

public class ActionTypeStrategyImpl implements ActionTypeStrategy {
    private final Map<String, ActionHandler> actionHandlerMap;

    public ActionTypeStrategyImpl(Map<String, ActionHandler> actionHandlerMap) {
        this.actionHandlerMap = actionHandlerMap;
    }

    @Override
    public ActionHandler get(String type) {
        return actionHandlerMap.get(type);
    }
}
