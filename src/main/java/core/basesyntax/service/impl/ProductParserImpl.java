package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ProductParser;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ProductParserImpl implements ProductParser {
    private static final int TYPE_OF_OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY = 2;
    private static final Map<String, Fruit.Operation> OPERATION_MAP = new HashMap<>();

    static {
        Fruit.Operation[] operations = Fruit.Operation.values();
        Arrays.stream(operations)
                .forEach(a -> OPERATION_MAP.put(a.getOperation(), a));
    }

    @Override
    public Fruit parse(String productInfo) {
        String[] data = productInfo.split(",");
        Fruit.Operation operation = OPERATION_MAP.get(data[TYPE_OF_OPERATION]);
        String nameFruit = data[FRUIT_NAME];
        int amount = Integer.parseInt(data[QUANTITY]);

        return new Fruit(operation, nameFruit, amount);
    }
}
