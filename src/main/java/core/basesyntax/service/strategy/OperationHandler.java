package core.basesyntax.service.strategy;

import core.basesyntax.dto.FruitTransactionDto;

public interface OperationHandler {
    void apply(FruitTransactionDto dto);

    boolean isApplicable(FruitTransactionDto dto);
}
