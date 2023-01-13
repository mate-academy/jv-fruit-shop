package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;

public interface Strategy {
    void getStrategy(Transaction transaction);
}
