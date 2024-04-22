package core.basesyntax.strategy;

import core.basesyntax.operation.StoreOperation;
import core.basesyntax.service.QuantityCounter;

public interface QuantityCounterStrategy {
    QuantityCounter get(StoreOperation operation);
}
