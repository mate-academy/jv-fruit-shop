package com.companyname.fruitshop.service.impl;

import com.companyname.fruitshop.model.Operation;
import com.companyname.fruitshop.service.interfaces.OperationHandler;
import com.companyname.fruitshop.service.interfaces.OperationStrategy;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
