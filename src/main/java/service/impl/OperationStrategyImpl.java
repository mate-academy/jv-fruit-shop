package service.impl;

import model.*;
import operations.*;
import operations.impl.*;
import service.*;

import java.util.*;

public class OperationStrategyImpl implements OperationStrategy {
    Map<FruitTransaction.Operation, OperationHandler> operationOperationHandlerMap = new HashMap<>();

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> operationOperationHandlerMap) {
        this.operationOperationHandlerMap = operationOperationHandlerMap;
    }

    @Override
    public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
        return operationOperationHandlerMap.get(operation);
    }
}
