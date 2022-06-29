package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationHandler;

public interface OperationService {
    OperationHandler getHandler(Transaction.Operation typeOperation);
}
