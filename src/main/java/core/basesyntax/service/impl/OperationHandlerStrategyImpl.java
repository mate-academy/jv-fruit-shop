package core.basesyntax.service.impl;

import core.basesyntax.model.TransactionLine;
import core.basesyntax.service.OperationHandlerStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class OperationHandlerStrategyImpl implements OperationHandlerStrategy {
    private final Map<String, OperationHandler> operationHandlerMap;

    public OperationHandlerStrategyImpl(Map<String, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(TransactionLine transactionLine) {
        String typeActivity = transactionLine.getTypeActivity();
        return operationHandlerMap.get(typeActivity.strip());
    }
}
