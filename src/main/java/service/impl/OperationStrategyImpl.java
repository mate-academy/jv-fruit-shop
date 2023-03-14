package service.impl;

import java.util.Map;
import model.TransactionDto;
import service.OperationStrategy;
import strategy.StrategyOperation;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<TransactionDto.Operation, StrategyOperation> operationHandlerMap;

    public OperationStrategyImpl(Map<TransactionDto.Operation,
            StrategyOperation> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public StrategyOperation get(TransactionDto.Operation type) {
        return operationHandlerMap.get(type);
    }
}
