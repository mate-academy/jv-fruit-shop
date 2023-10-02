package core.basesyntax.strategy;

import core.basesyntax.model.FruitsTransaction;
import core.basesyntax.service.operationhadler.TransactionHandler;

public interface Strategy {
    TransactionHandler getOperationHandler(FruitsTransaction.Operation operation);
}
