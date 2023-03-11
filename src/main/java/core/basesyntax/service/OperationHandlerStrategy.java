package core.basesyntax.service;

import core.basesyntax.model.TransactionLine;
import core.basesyntax.strategy.OperationHandler;

public interface OperationHandlerStrategy {
    OperationHandler get(TransactionLine transactionLine);
}
