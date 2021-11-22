package service;

import service.action.type.ActionStrategyHandler;

public interface ActionStrategy {
    ActionStrategyHandler get(String s);
}
