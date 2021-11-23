package shop.service.impl;

import java.util.HashMap;
import shop.service.action.ActionHandler;
import shop.service.action.ActionStrategyHandlers;

public class ActionStrategyHandlersImpl implements ActionStrategyHandlers {
    private final HashMap<String, ActionHandler> actionStrategyHashMap;

    public ActionStrategyHandlersImpl(HashMap<String, ActionHandler> actionStrategyHashMap) {
        this.actionStrategyHashMap = actionStrategyHashMap;
    }

    @Override
    public ActionHandler get(String actionType) {
        return actionStrategyHashMap.get(actionType);
    }
}
