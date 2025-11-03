package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import java.util.Arrays;

public class FruitParser {
    public static FruitTransaction parse(String fruitInfo) {
        if (fruitInfo == null || fruitInfo.isEmpty()) {
            throw new RuntimeException("fruit info can't be null or empty");
        }

        String[] parts = fruitInfo.split(",");

        if (parts.length != 3) {
            throw new RuntimeException("Invalid format. Incorrect count of fruit data: "
                    + parts.length);
        }

        FruitTransaction.Type type = getType(parts[0]);
        String name = parts[1];

        int quantity;
        try {
            quantity = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid quantity format", e);
        }

        return new FruitTransaction(type, name, quantity);
    }

    private static FruitTransaction.Type getType(String code) {
        return Arrays.stream(FruitTransaction.Type.values())
                .filter(t -> t.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown operation code: " + code));
    }
}
