package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;

public interface OperationStrategy {
    OperationHandler getHandler(Transaction transaction);
}
