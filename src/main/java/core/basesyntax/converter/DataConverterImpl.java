package core.basesyntax.converter;

import core.basesyntax.exceptions.InvalidCsvFormatException;
import core.basesyntax.exceptions.InvalidOperationException;
import core.basesyntax.transaction.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int SPLIT_ARRAY_LENGTH = 3;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> convertDataFromInputCsvFile(List<String> inputData) {
        return getSeparatedTransactions(inputData);
    }

    private List<FruitTransaction> getSeparatedTransactions(List<String> inputData) {
        nullCheckForInputData(inputData);
        List<FruitTransaction> result = new ArrayList<>();

        for (int i = 1; i < inputData.size(); i++) {
            String line = inputData.get(i);
            String[] splitted = line.split(SEPARATOR);

            if (splitted.length == SPLIT_ARRAY_LENGTH) {
                FruitTransaction fruitTransition = new FruitTransaction();
                fruitTransition.setOperation(
                        getOperationFromSplittedString(splitted[OPERATION_INDEX]));
                fruitTransition.setFruitName(
                        splitted[FRUIT_NAME_INDEX]);
                fruitTransition.setQuantity(
                        parseQuantityFromString(splitted[QUANTITY_INDEX]));
                result.add(fruitTransition);
            } else {
                throw new InvalidCsvFormatException("Invalid CSV format in line: " + line);
            }

        }
        return result;
    }

    private int parseQuantityFromString(String quantityInString) {
        try {
            return Integer.parseInt(quantityInString);
        } catch (NumberFormatException e) {
            throw new InvalidCsvFormatException("Invalid quantity format in CSV file!");
        }
    }

    private FruitTransaction.Operation getOperationFromSplittedString(String operation) {

        switch (operation.toLowerCase()) {
            case "b" -> {
                return FruitTransaction.Operation.B;
            }
            case "p" -> {
                return FruitTransaction.Operation.P;
            }
            case "r" -> {
                return FruitTransaction.Operation.R;
            }
            case "s" -> {
                return FruitTransaction.Operation.S;
            }
            default -> throw new InvalidOperationException("Invalid operation format in CSV file!");
        }
    }

    private void nullCheckForInputData(List<String> inputData) {
        if (inputData == null || inputData.stream().anyMatch(a -> a == null || a.isEmpty())) {
            throw new InvalidOperationException("Input data contains null or empty values!");
        }
    }
}
