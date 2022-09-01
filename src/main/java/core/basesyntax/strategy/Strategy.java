package core.basesyntax.strategy;

import core.basesyntax.dto.Transaction;

public interface Strategy {
    void makeOperation(Transaction transaction);
}
