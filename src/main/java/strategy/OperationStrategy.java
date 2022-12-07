package strategy;

import strategy.handler.OperationHandler;

public interface OperationStrategy {

    OperationHandler get(String operation);
}
