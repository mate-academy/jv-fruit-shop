package shop.service.impl;

import java.util.HashMap;
import shop.service.action.ActionHandler;
import shop.service.action.ActionStrategyHandler;

public class ActionStrategyHandlerImpl implements ActionStrategyHandler {
    private final HashMap<String, ActionHandler> actionStrategyHashMap;

    public ActionStrategyHandlerImpl(HashMap<String, ActionHandler> actionStrategyHashMap) {
        this.actionStrategyHashMap = actionStrategyHashMap;
    }

    @Override
    public ActionHandler get(String actionType) {
        return actionStrategyHashMap.get(actionType);
    }
}
