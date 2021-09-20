package service.impl;

import service.OperationStrategy;
import service.strategy.BalanceHandler;
import service.strategy.Handler;
import service.strategy.PurchaseHandler;
import service.strategy.ReturnHandler;
import service.strategy.SupplyHandler;

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
