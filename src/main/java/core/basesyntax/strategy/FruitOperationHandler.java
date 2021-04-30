package core.basesyntax.strategy;

import core.basesyntax.dto.FruitRecordDto;

import java.io.IOException;

public interface FruitOperationHandler {
    void apply(FruitRecordDto fruitRecordDto);

    default void checkQuantity(Integer quantity) {
        if (quantity < 0) {
            throw new RuntimeException("відємне значення кількості фруктів");
        }
    }
}
