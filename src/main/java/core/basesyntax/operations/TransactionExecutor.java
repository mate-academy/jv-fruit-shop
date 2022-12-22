package core.basesyntax.operations;

import core.basesyntax.service.FruitTransaction;

public interface TransactionExecutor {
    void execute(FruitTransaction fruitTransaction);
}
