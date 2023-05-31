package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface FruitStrategy {
    TypeStrategy get(FruitTransaction.Operation operation);
}
