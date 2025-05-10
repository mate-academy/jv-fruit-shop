package core.basesyntax.services.operations;

import core.basesyntax.dto.FruitTransactionDto;

public interface OperationHandler {
    void apply(FruitTransactionDto dto);

    boolean isApplicable(FruitTransactionDto dto);
}
