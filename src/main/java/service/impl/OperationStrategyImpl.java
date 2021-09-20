package service.impl;

import service.OperationStrategy;
import service.operation.BalanceHandler;
import service.operation.Handler;
import service.operation.PurchaseHandler;
import service.operation.ReturnHandler;
import service.operation.SupplyHandler;

public class OperationStrategyImpl implements OperationStrategy {
    @Override
    public Handler get(String[] str) {
        switch (str[0]) {
            case "b":
                return new BalanceHandler();
            case "s":
                return new SupplyHandler();
            case "p":
                return new PurchaseHandler();
            case "r":
                return new ReturnHandler();
            default:
                throw new RuntimeException("invalid input parameter " + str[0]);
        }
    }
}
