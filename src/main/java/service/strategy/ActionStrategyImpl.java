package service.strategy;

import java.util.HashMap;
import service.action.ActionStrategyHandler;

public class ActionStrategyImpl implements ActionStrategy {
    private final HashMap<String, ActionStrategyHandler> actionStrategyHashMap;

    public ActionStrategyImpl(HashMap<String, ActionStrategyHandler> actionStrategyHashMap) {
        this.actionStrategyHashMap = actionStrategyHashMap;
    }

    @Override
    public ActionStrategyHandler get(String actionType) {
        return actionStrategyHashMap.get(actionType);
    }
}
