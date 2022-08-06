package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;

public class CsvParserServiceImpl implements ParserService<FruitTransaction> {
    private static final String SEPARATOR = ",";
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT_NAME = 1;
    private static final int INDEX_FRUIT_AMOUNT = 2;

    @Override
    public FruitTransaction parse(String line) {
        String[] data = line.split(SEPARATOR);
        String operation = data[INDEX_OPERATION].trim();
        String fruit = data[INDEX_FRUIT_NAME].trim();
        int quantity = Integer.parseInt(data[INDEX_FRUIT_AMOUNT].trim());
        if (quantity < 0) {
            throw new RuntimeException("Quantity can't be negative.");
        }
        return new FruitTransaction()
                .setOperation(operation)
                .setFruit(fruit)
                .setQuantity(quantity);
    }
}
