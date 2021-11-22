package service;

import service.action.type.ActionBalanceHandler;
import service.action.type.ActionPurchaseHandler;
import service.action.type.ActionReturnHandler;
import service.action.type.ActionStrategyHandler;
import service.action.type.ActionSupplyHandler;

public class ActionStrategyImpl implements ActionStrategy {
    @Override
    public ActionStrategyHandler get(String s) {
        switch (s) {
            case "b":
                return new ActionBalanceHandler();
            case "r":
                return new ActionReturnHandler();
            case "s":
                return new ActionSupplyHandler();
            case "p":
                return new ActionPurchaseHandler();
            default:
                throw new RuntimeException("Invalid action type");
        }
    }
}
