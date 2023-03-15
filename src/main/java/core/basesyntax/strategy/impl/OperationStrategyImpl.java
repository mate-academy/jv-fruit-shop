package core.basesyntax.strategy.impl;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handler.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<TransactionDto.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<TransactionDto.Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(TransactionDto.Operation type) {
        return operationHandlerMap.get(type);
    }
}
