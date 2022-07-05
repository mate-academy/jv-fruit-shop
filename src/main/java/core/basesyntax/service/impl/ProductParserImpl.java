package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProductParser;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductParserImpl implements ProductParser {
    private static final int INDEX_TYPE_OF_OPERATION = 0;
    private static final int INDEX_FRUIT_NAME = 1;
    private static final int INDEX_QUANTITY = 2;
    private static final Map<String, FruitTransaction.Operation> OPERATION_MAP = new HashMap<>();

    static {
        FruitTransaction.Operation[] operations = FruitTransaction.Operation.values();
        Arrays.stream(operations)
                .forEach(a -> OPERATION_MAP.put(a.getOperation(), a));
    }

    @Override
    public FruitTransaction parse(String productInfo) {
        String[] data = productInfo.split(",");
        FruitTransaction.Operation operation = OPERATION_MAP.get(data[INDEX_TYPE_OF_OPERATION]);
        String nameFruit = data[INDEX_FRUIT_NAME];
        int amount = Integer.parseInt(data[INDEX_QUANTITY]);
        return new FruitTransaction(operation, nameFruit, amount);
    }

    @Override
    public List<FruitTransaction> parseAll(List<String> list) {
        return list.stream()
                .map(this::parse)
                .collect(Collectors.toList());
    }
}
