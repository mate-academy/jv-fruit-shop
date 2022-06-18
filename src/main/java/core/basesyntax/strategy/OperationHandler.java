package core.basesyntax.strategy;

import core.basesyntax.model.TransactionInfo;

public interface OperationHandler {
    void handle(TransactionInfo fruitTransaction);
}
