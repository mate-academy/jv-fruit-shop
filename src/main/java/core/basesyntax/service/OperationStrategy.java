package core.basesyntax.service;

import core.basesyntax.service.strategy.FruitOperations;

public interface OperationStrategy {
    FruitOperations get(String operation);
}
