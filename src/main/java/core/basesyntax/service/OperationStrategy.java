package core.basesyntax.service;

import core.basesyntax.dao.strategy.FruitOperations;

public interface OperationStrategy {
    FruitOperations get(String operation);
}
