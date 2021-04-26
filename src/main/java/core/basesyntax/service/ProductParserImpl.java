package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.ProductFactory;
import java.util.ArrayList;
import java.util.List;

public class ProductParserImpl implements ProductParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SPLITERATOR = ",";

    @Override
    public List<ProductFactory> parseProduct(List<String> records) {
        List<ProductFactory> factories = new ArrayList<>();
        for (String record : records) {
            String[] fields = record.split(SPLITERATOR);
            Operation operation = Operation.getOperationByLetter(fields[OPERATION_INDEX]);
            Fruit fruit = new Fruit(fields[FRUIT_INDEX]);
            int amount = Integer.parseInt(fields[QUANTITY_INDEX]);
            if (amount < 0) {
                throw new RuntimeException("Value cannot be less than zero " + amount);
            }
            ProductFactory product = new ProductFactory(operation, fruit, amount);
            factories.add(product);
        }
        return factories;
    }
}