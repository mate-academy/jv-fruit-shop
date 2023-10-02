package core.basesyntax.service.operationhadler;

import core.basesyntax.model.FruitsTransaction;

public interface TransactionHandler {
    void handleTransaction(FruitsTransaction transaction);
}

