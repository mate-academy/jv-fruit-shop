package core.basesyntax.handler;

import core.basesyntax.fruit.Transaction;

public interface OperationHandler {
    void execute(Transaction transaction);
}
