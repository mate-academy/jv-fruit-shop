package core.basesyntax.service;

import core.basesyntax.operations.Operation;

public interface FruitOperationStrategy {
    Operation get(String typeOfOperation);
}
