package core.basesyntax.service;

import core.basesyntax.strategy.OperationsHandler;

public interface FruitService {
    OperationsHandler getOperationStrategies(String operationsCode);
}
