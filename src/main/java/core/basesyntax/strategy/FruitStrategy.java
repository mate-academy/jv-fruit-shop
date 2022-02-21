package core.basesyntax.strategy;

import core.basesyntax.service.operations.FruitOperation;

public interface FruitStrategy {
    FruitOperation makeOperation(String abbreviation);
}
