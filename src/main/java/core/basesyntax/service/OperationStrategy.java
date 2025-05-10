package core.basesyntax.service;

import core.basesyntax.dto.FruitTransactionDto;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransactionDto fruitTransactionDto);
}
