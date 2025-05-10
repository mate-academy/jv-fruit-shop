package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitMapper;
import java.util.ArrayList;
import java.util.List;

public class FruitMapperImpl implements FruitMapper {
    private static final String COMMA = ",";
    private static final int INDEX_OF_TITLE = 0;
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_PRODUCT_NAME = 1;
    private static final int INDEX_OF_PRODUCT_AMOUNT = 2;

    @Override
    public List<Fruit> convert(List<String> data) {
        data.remove(INDEX_OF_TITLE);
        List<Fruit> fruits = new ArrayList<>();
        for (String line : data) {
            String[] split = line.split(COMMA);
            Operation operation = Operation.fromCode(split[INDEX_OF_OPERATION]);
            String productName = split[INDEX_OF_PRODUCT_NAME];
            int amount = Integer.parseInt(split[INDEX_OF_PRODUCT_AMOUNT]);
            fruits.add(new Fruit(productName, operation, amount));
        }
        return fruits;
    }
}
