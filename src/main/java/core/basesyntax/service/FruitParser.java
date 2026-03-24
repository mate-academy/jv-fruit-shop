package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;

public class FruitParser {
    private static final int ENUM_OPERATION = 0;
    private static final int NAME_OF_FRUIT = 1;
    private static final int QUANTITY_OF_FRUIT = 2;

    public FruitTransaction parse(String line) {
        String[] data = line.split(",");

        Operation operation = getOperationByCode(data[ENUM_OPERATION]);

        String fruitName = data[NAME_OF_FRUIT];
        int quantityOfFruit = Integer.parseInt(data[QUANTITY_OF_FRUIT]);

        return FruitTransaction.of(operation, fruitName, quantityOfFruit);
    }

    private Operation getOperationByCode(String code) {
        for (Operation op : Operation.values()) {
            if (op.name().equalsIgnoreCase(code)) {
                return op;
            }
        }
        throw new RuntimeException("Unknown operation type: " + code);
    }
}
