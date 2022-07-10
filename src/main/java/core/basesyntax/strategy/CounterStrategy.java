package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.quantity.CounterHandler;

public interface CounterStrategy {
    CounterHandler get(FruitTransaction.Operation operation);
}
