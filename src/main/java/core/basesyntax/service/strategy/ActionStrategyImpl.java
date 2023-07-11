package core.basesyntax.service.strategy;

import core.basesyntax.service.operation.Handler;
import java.util.Map;

public class ActionStrategyImpl implements ActionStrategy {
    private final Map<String, Handler> actionStrategyHashMap;

    public ActionStrategyImpl(Map<String, Handler> actionStrategyHashMap) {
        this.actionStrategyHashMap = actionStrategyHashMap;
    }

    @Override
    public Handler get(String action) {
        return actionStrategyHashMap.get(action);
    }
}
