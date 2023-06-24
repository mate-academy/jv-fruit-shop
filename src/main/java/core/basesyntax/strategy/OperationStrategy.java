package core.basesyntax.strategy;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(TransactionDto.Operation type);
}
