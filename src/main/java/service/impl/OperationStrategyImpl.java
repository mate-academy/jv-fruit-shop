package service.impl;

import service.OperationStrategy;
import service.strategy.Handler;

public class OperationStrategyImpl implements OperationStrategy {
    @Override
    public Handler get(String[] str) {
        return map.get(str[0]);
    }
}
