package core.basesyntax.service.impl;

import core.basesyntax.model.DailyActivity;
import core.basesyntax.service.OperationHandlerStrategy;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.Map;

public class OperationHandlerStrategyImpl implements OperationHandlerStrategy {
    private final Map<String, OperationHandler> operationHandlerMap;

    public OperationHandlerStrategyImpl(Map<String, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(DailyActivity dailyActivity) {
        String typeActivity = dailyActivity.getActivityType();
        return operationHandlerMap.get(typeActivity.strip());
    }
}
