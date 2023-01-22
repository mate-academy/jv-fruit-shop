package service.impl;

import java.util.Map;
import model.Operation;
import service.FruitTransactionProcessor;
import strategy.OperationHandler;

public class FruitTransactionProcessorImpl implements FruitTransactionProcessor {
    private final Map<Operation, OperationHandler> operationHandlerMap;

    public FruitTransactionProcessorImpl(Map<Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
