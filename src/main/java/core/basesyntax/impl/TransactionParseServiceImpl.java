package core.basesyntax.impl;

import core.basesyntax.FruitTransaction;
import core.basesyntax.service.ParseService;

public class TransactionParseServiceImpl implements ParseService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";

    @Override
    public Object parse(String line) {
        String[] data = line.split(SEPARATOR);
        String operation = data[OPERATION_INDEX].trim();
        String fruit = data[FRUIT_INDEX].trim();
        int quantity = Integer.parseInt(data[QUANTITY_INDEX].trim());
        if (quantity < 0) {
            throw new RuntimeException("Quantity can't have a negative value.");
        }
        return new FruitTransaction()
                .typeOperation(operation)
                .typeFruit(fruit)
                .typeQuantity(quantity);
    }
}
