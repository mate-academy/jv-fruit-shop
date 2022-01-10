package core.basesyntax.strategy;

import core.basesyntax.model.TransactionLine;

public interface OperationHandler {
    void operation(TransactionLine transactionLine);
}
