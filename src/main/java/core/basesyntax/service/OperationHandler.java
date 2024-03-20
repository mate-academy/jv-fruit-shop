package core.basesyntax.service;

import core.basesyntax.dto.FruitTransactionDto;

public interface OperationHandler {
    void handle(FruitTransactionDto fruitTransactionDto);
}
