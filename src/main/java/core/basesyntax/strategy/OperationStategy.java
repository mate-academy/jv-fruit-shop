package core.basesyntax.strategy;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.operation.OperationHandler;

public interface OperationStategy {
    OperationHandler get(FruitTransactionDto dto);
}
