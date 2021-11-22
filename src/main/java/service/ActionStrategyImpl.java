package service;

import service.action.type.ActionMinusCountHandler;
import service.action.type.ActionPlusCountHandler;
import service.action.type.ActionStrategyHandler;

public class ActionStrategyImpl implements ActionStrategy {

    @Override
    public ActionStrategyHandler get(String s) {
        switch (s) {
            case "b":
            case "r":
            case "s":
                return new ActionPlusCountHandler();
            case "p":
                return new ActionMinusCountHandler();
            default:
                throw new RuntimeException("Invalid action type");
        }
    }
}
