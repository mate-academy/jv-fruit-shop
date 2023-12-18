package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ParserService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;

    @Override
    public List<Fruit> parseData(List<String> fruits) {
        return fruits.stream()
                .map(fruit -> fruit.split(","))
                .map(splitted -> {
                    String fruitOpCode = splitted[OPERATION_INDEX];
                    Fruit.Operation operation = Arrays.stream(Fruit.Operation.values())
                            .filter(op -> op.getCode().equals(fruitOpCode))
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException("Unknown opcode: "
                                    + fruitOpCode));
                    String fruitName = splitted[FRUIT_NAME_INDEX];
                    int fruitQuantity = Integer.parseInt(splitted[FRUIT_QUANTITY_INDEX].trim());
                    if (fruitQuantity < 0) {
                        throw new RuntimeException("Wrong quantity input");
                    }
                    return new Fruit(operation, fruitName, fruitQuantity);
                })
                .collect(Collectors.toList());
    }
}
