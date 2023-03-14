package service.impl;

import java.util.HashMap;
import java.util.Map;
import model.Operation;
import service.OperationStrategy;
import strategy.BalanceOperationHandler;
import strategy.OperationHandler;
import strategy.PurchaseOperationHandler;
import strategy.ReturnOperationHandler;
import strategy.SupplyOperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> operations;

    public OperationStrategyImpl() {
        operations = new HashMap<>();
        operations.put(Operation.BALANCE, new BalanceOperationHandler());
        operations.put(Operation.RETURN, new ReturnOperationHandler());
        operations.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operations.put(Operation.SUPPLY, new SupplyOperationHandler());
    }

    @Override
    public OperationHandler get(Operation actionType) {
        return operations.get(actionType);
    }
}
