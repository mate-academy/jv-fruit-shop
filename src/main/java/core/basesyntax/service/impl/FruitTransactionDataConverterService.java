package core.basesyntax.service.impl;

import core.basesyntax.exception.InvalidDataFormatException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverterService;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionDataConverterService implements DataConverterService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int NUMBER_OF_FRUITS_INDEX = 2;
    private static final String DATA_SEPARATOR = ",";
    private static final List<String> OPERATIONS = List.of("b", "s", "p", "r");

    @Override
    public List<FruitTransaction> convertDataToObjects(String dataFromFile) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        String[] data = dataFromFile.split("\\n");
        for (int i = 1; i < data.length; i++) {
            FruitTransaction fruitTransaction = createFruitObjectFromData(data[i]);
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }

    private FruitTransaction createFruitObjectFromData(String data) {
        String[] fieldsOfInfo = data.replaceAll("\\r", "").split(DATA_SEPARATOR);
        String name = fieldsOfInfo[FRUIT_NAME_INDEX];
        Integer quantity = Integer.valueOf(fieldsOfInfo[NUMBER_OF_FRUITS_INDEX]);
        String operation = fieldsOfInfo[OPERATION_INDEX];

        isValid(operation, name, quantity);
        return new FruitTransaction(name, quantity, Operation.of(operation));
    }

    private boolean isValid(String operation, String fruitName, Integer quantity) {
        return isValidOperation(operation)
                && isValidFruitName(fruitName)
                && isValidQuantity(quantity);
    }

    private boolean isValidOperation(String operation) {
        if (!OPERATIONS.contains(operation)) {
            throw new InvalidDataFormatException(operation + " is invalid operation!");
        }
        return true;
    }

    private boolean isValidFruitName(String name) {
        if (name.matches("[\\W\\d]") || name.isBlank()) {
            throw new InvalidDataFormatException("Fruit name should consist "
                    + "any letters and special characters!");
        }
        return true;
    }

    private boolean isValidQuantity(Integer quantity) {
        if (quantity < 0) {
            throw new InvalidDataFormatException("The number of fruits can't be less than zero!");
        }
        return true;
    }
}
