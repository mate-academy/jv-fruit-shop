package core.basesyntax.service.strategy;

import core.basesyntax.model.Operation;

public interface FruitTransactionStrategy {
    FruitTransactionHandler get(Operation type);
}
