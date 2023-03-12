package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;

public class TransactionCsvParseServiceImpl implements ParseService<FruitTransaction> {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String DELIMITER = ",";

    @Override
    public FruitTransaction parse(String lines) {
        String[] data = lines.split(DELIMITER);
        String operation = data[OPERATION_INDEX].trim();
        String fruit = data[FRUIT_INDEX].trim();
        int quantity = Integer.parseInt(data[QUANTITY_INDEX].trim());
        if (quantity < 0) {
            throw new RuntimeException("Error! Quantity can't have a negative value.");
        }
        return new FruitTransaction()
                    .setOperation(operation)
                    .setFruit(fruit)
                    .setQuantity(quantity);
    }
}
