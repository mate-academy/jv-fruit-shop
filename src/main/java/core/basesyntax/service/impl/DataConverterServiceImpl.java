package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverterService;
import java.util.List;

public class DataConverterServiceImpl implements DataConverterService {
    private static final int LINES_TO_SKIP = 1;
    private static final int NECESSARY_COUNT_OF_ELEMENTS = 3;
    private static final String COMMA_REGEX = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        return inputReport.stream()
                .skip(LINES_TO_SKIP) //for skipping title
                .map(this::convertStringToFruitTransaction)
                .toList();
    }

    private FruitTransaction convertStringToFruitTransaction(String line) {
        String[] fruitTransactionElements = line.split(COMMA_REGEX);
        if (fruitTransactionElements.length != NECESSARY_COUNT_OF_ELEMENTS) {
            throw new RuntimeException("Line: '" + line
                    + "' doesn't match to pattern 'type,fruit,quantity'");
        }

        FruitTransaction.Operation operation = FruitTransaction.Operation
                .fromCode(fruitTransactionElements[OPERATION_INDEX]);

        Fruit fruit = new Fruit(fruitTransactionElements[FRUIT_INDEX]);

        String quantityString = fruitTransactionElements[QUANTITY_INDEX];
        int quantity;
        try {
            quantity = Integer.parseInt(quantityString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid quantity format: " + quantityString, e);
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity can't be negative. "
                    + "Input quantity: " + quantity);
        }
        return new FruitTransaction(operation, fruit, quantity);
    }
}
