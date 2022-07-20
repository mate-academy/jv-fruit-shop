package core.basesyntax.strategy.operations;

import core.basesyntax.model.Transaction;

public interface OperationHandler {
    //int getOperationalQuantity(int quantity);
    void handle(Transaction transaction);
}
