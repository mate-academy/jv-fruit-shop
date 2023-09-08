package service.strategy;

import java.util.HashMap;
import model.Operation;
import service.action.ActionStrategyHandler;

public class ActionStrategyImpl implements ActionStrategy {
    private final HashMap<Operation, ActionStrategyHandler> actionStrategyHashMap;

    public ActionStrategyImpl(HashMap<Operation, ActionStrategyHandler> actionStrategyHashMap) {
        this.actionStrategyHashMap = actionStrategyHashMap;
    }

    @Override
    public ActionStrategyHandler get(String actionType) {
        return actionStrategyHashMap.get(Operation.valueOf(actionType.toUpperCase()));
    }
}
