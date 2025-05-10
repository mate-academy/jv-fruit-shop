package core.basesyntax.service;

import core.basesyntax.dto.FruitTransactionDto;

public interface DataValidator {
    void validate(FruitTransactionDto fruitTransactionDto);
}
