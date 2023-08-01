package core.basesyntax.operations;

import core.basesyntax.transactions.FruitTransaction;

public interface OperationStrategy {
    void get(FruitTransaction transaction);
}
