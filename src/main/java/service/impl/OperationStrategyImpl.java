package service.impl;

import model.Operation;
import service.OperationHandler;
import service.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    @Override
    public OperationHandler getOperationHandler(Operation operation) {
        return switch (operation) {
            case BALANCE -> new BalanceOperationHandler();
            case RETURN -> new ReturnOperationHandler();
            case SUPPLY -> new SupplyOperationHandler();
            case PURCHASE -> new PurchaseOperationHandler();
        };
    }
}
