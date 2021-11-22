package service.strategy;

import service.action.ActionStrategyHandler;
import service.action.type.ActionMinusQuantityHandler;
import service.action.type.ActionPlusQuantityHandler;

public class ActionStrategyImpl implements ActionStrategy {

    @Override
    public ActionStrategyHandler get(String s) {
        switch (s) {
            case "b": //Balance
            case "r": //Return
            case "s": //Supply
                return new ActionPlusQuantityHandler();
            case "p": //Purchase
                return new ActionMinusQuantityHandler();
            default:
                throw new RuntimeException("Invalid action type");
        }
    }
}
