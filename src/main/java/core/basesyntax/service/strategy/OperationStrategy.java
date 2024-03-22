package core.basesyntax.service.strategy;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.operations.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransactionDto dto);
}
