package core.basesyntax.service;

import core.basesyntax.dto.FruitTransactionDto;

public interface DataValidator {
    void validate(FruitTransactionDto fruitTransactionDto);

    void validateOperation(FruitTransactionDto fruitTransactionDto);

    void validateFruitType(FruitTransactionDto fruitTransactionDto);

    void validateQuantity(FruitTransactionDto fruitTransactionDto);
}
