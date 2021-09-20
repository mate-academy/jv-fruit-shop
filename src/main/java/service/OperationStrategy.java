package service;

import service.strategy.Handler;

public interface OperationStrategy {
    Handler get(String[] str);
}
