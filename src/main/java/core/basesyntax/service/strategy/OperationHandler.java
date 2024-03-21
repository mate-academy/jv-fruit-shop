package core.basesyntax.service.strategy;

import core.basesyntax.dto.FruitTransactionDto;

public interface OperationHandler {
    void handle(FruitTransactionDto dto);

    boolean isApplicable(FruitTransactionDto dto);
}
