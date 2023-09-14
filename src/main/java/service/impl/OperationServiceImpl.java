package service.impl;

import core.basesyntax.Main;
import service.OperationService;
import strategy.Operation;
import strategy.OperationHandler;

public class OperationServiceImpl implements OperationService {
    @Override
    public OperationHandler createOperation(String operationSymbol) {
        for (Operation key : Main.getOperationMap().keySet()) {
            if (key.getCode().equals(operationSymbol)) {
                return Main.getOperationMap().get(key);
            }
        }
        throw new RuntimeException("No such operation");
    }
}
