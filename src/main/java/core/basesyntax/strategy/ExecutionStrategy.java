package core.basesyntax.strategy;

import core.basesyntax.FruitStorage;
import core.basesyntax.model.Transaction;

public interface ExecutionStrategy {
    void execute(Transaction transaction, FruitStorage storage);
}
