package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitMovement;
import core.basesyntax.model.MovementType;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.List;

public class FruitMovementParser implements Parser {
    private static final int OPERATOIN_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_AMOUNT_INDEX = 2;

    @Override
    public List<FruitMovement> parse(List<String[]> input) {
        List<FruitMovement> result = new ArrayList<>();
        if (input == null || input.isEmpty()) {
            return result;
        }
        for (String[] record : input) {
            Fruit fruit = new Fruit(record[FRUIT_NAME_INDEX]);
            MovementType type = getType(record[OPERATOIN_TYPE_INDEX]);
            int value = Integer.parseInt(record[FRUIT_AMOUNT_INDEX]);
            FruitMovement fruitMovement = new FruitMovement(fruit, type, value);
            result.add(fruitMovement);
        }
        return result;
    }

    private MovementType getType(String symbol) {
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
