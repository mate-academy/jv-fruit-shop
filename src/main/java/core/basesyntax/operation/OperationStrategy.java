package core.basesyntax.operation;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    void get(FruitTransaction transaction);
}
