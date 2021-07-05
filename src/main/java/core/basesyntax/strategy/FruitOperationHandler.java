package core.basesyntax.strategy;

import core.basesyntax.dto.FruitRecordDto;

public interface FruitOperationHandler {
    void apply(FruitRecordDto fruitRecordDto);

    default void checkQuantity(Integer quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Use positive numbers...");
        }
    }
}
