package core.basesyntax.services.operation;

import core.basesyntax.model.TransactionDto;

public interface Strategy {
    OperationHandler get(TransactionDto.Type operation);
}
