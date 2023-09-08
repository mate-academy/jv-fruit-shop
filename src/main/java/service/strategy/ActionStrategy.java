package service.strategy;

import service.action.ActionStrategyHandler;

public interface ActionStrategy {
    ActionStrategyHandler get(String s);
}
