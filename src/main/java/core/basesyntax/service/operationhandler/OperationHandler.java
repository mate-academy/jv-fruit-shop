package core.basesyntax.service.operationhandler;

import core.basesyntax.model.TransactionDto;

public interface OperationHandler {
    void apply(TransactionDto fruit);
}
