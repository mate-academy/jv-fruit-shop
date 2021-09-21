package core.basesyntax.service.strategy;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.operations.OperationHendler;

public interface OperationsStrategy {
    OperationHendler get(TransactionDto.OperationTypes operationTypes);
}
