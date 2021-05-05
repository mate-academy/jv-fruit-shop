package core.basesyntax.service;

import core.basesyntax.model.dto.FruitRecordDto;

public interface Operation {
    int apply(FruitRecordDto fruitRecordDto);

    default void checkQuantity(Integer quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Wrong fruit quantity: " + quantity);
        }
    }

    default void checkFruitType(String fruitType) {
        if (fruitType.equals("")
                || fruitType.length() > fruitType.replaceAll("[^A-z]", "").length()) {
            throw new RuntimeException("Incorrect fruit type: " + fruitType);
        }
    }
}
