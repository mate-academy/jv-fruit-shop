package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    void process(FruitTransaction transaction);
}
