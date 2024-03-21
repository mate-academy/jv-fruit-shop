package core.basesyntax.service.strategy;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.model.Operation;

public interface OperationHandler {
    void handle(FruitTransactionDto dto);

    boolean isApplicable(FruitTransactionDto dto);

    Operation getOperation();
}
