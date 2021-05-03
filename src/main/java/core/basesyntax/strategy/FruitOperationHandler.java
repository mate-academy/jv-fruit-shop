package core.basesyntax.strategy;

import core.basesyntax.dto.FruitRecordDto;

public interface FruitOperationHandler {
    void apply(FruitRecordDto fruitRecordDto);

    default void checkQuantity(Integer quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Negative value of the number of fruits");
        }
    }

    default void checkFruitName(String fruitType) {
        if (fruitType.equals("null") || fruitType.equals("")) {
            throw new RuntimeException("Wrong fruit name - " + fruitType);
        }
    }
}
