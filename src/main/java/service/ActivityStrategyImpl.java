package service;

import java.util.Map;
import service.actions.ActivityHandler;

public class ActivityStrategyImpl implements ActivityStrategy {
    private Map<String, ActivityHandler> actionHandlerMap;

    public ActivityStrategyImpl(Map<String, ActivityHandler> actionHandlerMap) {
        this.actionHandlerMap = actionHandlerMap;
    }

    @Override
    public ActivityHandler get(String action) {
        return actionHandlerMap.get(action);
    }
}
