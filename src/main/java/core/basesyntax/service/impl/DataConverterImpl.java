package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION_CODE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> result = new ArrayList<>();
        for (String data : lines) {
            result.add(parseLine(data));
        }
        return result;
    }

    private FruitTransaction parseLine(String line) {
        if (line == null || line.trim().isEmpty()) {
            throw new RuntimeException("Line is empty");
        }
        String[] data = line.split(",");
        if (data.length != 3) {
            throw new RuntimeException("Bad number of data");
        }
        String operationCode = data[OPERATION_CODE_INDEX].trim();
        String fruit = data[FRUIT_INDEX].trim();
        String quantityString = data[QUANTITY_INDEX].trim();
        if (operationCode.isBlank()) {
            throw new RuntimeException("Operation isn't provided");
        }
        if (fruit.isBlank()) {
            throw new RuntimeException("Fruit isn't provided");
        }
        if (quantityString.isBlank()) {
            throw new RuntimeException("Quantity isn't provided");
        }
        int quantity;
        try {
            quantity = Integer.parseInt(quantityString);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Quantity must be a number: " + quantityString);
        }
        if (quantity <= 0) {
            throw new RuntimeException("Quantity must be a positive number: " + quantityString);
        }
        Operation operation = Operation.fromCode(operationCode);
        return new FruitTransaction(fruit, operation, quantity);
    }
}
