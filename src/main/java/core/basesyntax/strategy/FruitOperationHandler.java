package core.basesyntax.strategy;

import core.basesyntax.dto.FruitRecordDto;

public interface FruitOperationHandler {
    String EXCEPT_LETTERS = "[^A-z]";
    void apply(FruitRecordDto fruitRecordDto);

    default void checkQuantity(Integer quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Negative value of the number of fruits");
        }
    }

    default void checkFruitName(String fruitType) {
        if (fruitType.equals("null")
                || fruitType.equals("")
                || fruitType.length() > fruitType.replaceAll(EXCEPT_LETTERS, "").length()) {
            throw new RuntimeException("Wrong fruit name - " + fruitType);
        }
    }
}
