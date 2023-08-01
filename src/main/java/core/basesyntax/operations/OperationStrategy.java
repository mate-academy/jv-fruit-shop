package core.basesyntax.operations;

import core.basesyntax.Transactions.FruitTransaction;

public interface OperationStrategy {
    void get(FruitTransaction transaction);
}
