package com.basesyntax.strategy;

import com.basesyntax.dao.OperationHandler;

public interface Strategy {
    void addStrategyType(String operationType, OperationHandler operationHandler);

    OperationHandler getStrategyType(String type);
}
