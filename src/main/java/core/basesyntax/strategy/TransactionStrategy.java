package core.basesyntax.strategy;

import core.basesyntax.model.TransactionDto;

public interface TransactionStrategy {
    OperationHandler get(TransactionDto.Operation operation);
}
