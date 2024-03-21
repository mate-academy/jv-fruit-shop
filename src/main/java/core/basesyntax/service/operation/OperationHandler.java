package core.basesyntax.service.operation;

import core.basesyntax.dto.FruitTransactionDto;

public interface OperationHandler {
    public void apply(FruitTransactionDto dto);
}
