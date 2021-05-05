package core.basesyntax.service;

import core.basesyntax.model.dto.FruitRecordDto;

public interface FruitOperationHandler {
    String LETTERS = "[^A-z]";
    int apply(FruitRecordDto fruitRecordDto);

    default void checkQuantity(Integer quantity) {
        if (quantity < 0) {
            throw new RuntimeException("We don't have enough fruits");
        }
    }

    default void checkFruits(String fruitName) {
        if (fruitName.equals("") || fruitName.length()
                > fruitName.replaceAll(LETTERS, "").length()) {
            throw new RuntimeException("We don't have this type of fruits");
        }
    }
}
