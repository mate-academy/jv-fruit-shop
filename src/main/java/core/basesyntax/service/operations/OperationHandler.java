package core.basesyntax.service.operations;

import core.basesyntax.dto.FruitTransactionDto;

public interface OperationHandler {
    void apply(FruitTransactionDto dto);
}
