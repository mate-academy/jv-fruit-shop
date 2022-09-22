package core.basesyntax.strategy;

import core.basesyntax.service.operationwithfruits.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(String operator);
}
