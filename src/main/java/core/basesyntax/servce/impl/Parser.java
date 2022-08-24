package core.basesyntax.servce.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitMovement;
import core.basesyntax.model.MovementType;
import core.basesyntax.servce.CsvParser;
import java.util.ArrayList;
import java.util.List;

public class Parser implements CsvParser {
    private static final int TYPE = 0;
    private static final int FRUIT_NAME = 1;
    private static final int FRUIT_VALUE = 2;

    @Override
    public List<FruitMovement> parse(List<String[]> input) {
        List<FruitMovement> result = new ArrayList<>();
        if (input == null || input.isEmpty()) {
            return result;
        }
        for (String[] record : input) {
            Fruit fruit = new Fruit(record[FRUIT_NAME]);
            MovementType type = getType(record[TYPE]);
            int value = Integer.parseInt(record[FRUIT_VALUE]);
            FruitMovement fruitMovement = new FruitMovement(fruit, type, value);
            result.add(fruitMovement);
        }
        return result;
    }

    private static MovementType getType(String symbol) {
        switch (symbol) {
            case "b":
                return MovementType.BALANCE;
            case "s":
                return MovementType.SUPPLY;
            case "p":
                return MovementType.PURCHASE;
            case "r":
                return MovementType.RETURN;
            default:
                throw new RuntimeException("The file contains wrong data."
                        + " First symbol can only be 'b','s','p' or 'r'");
        }
    }
}
