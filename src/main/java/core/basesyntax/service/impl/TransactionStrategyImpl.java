package core.basesyntax.service.impl;

import core.basesyntax.model.LineData;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.TransactionStrategy;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private final Map<String, OperationHandler> operationMap;

    public TransactionStrategyImpl(Map<String, OperationHandler> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public OperationHandler get(LineData lineData) {
        String operationType = lineData.getAction();
        return operationMap.get(operationType);
    }
}
