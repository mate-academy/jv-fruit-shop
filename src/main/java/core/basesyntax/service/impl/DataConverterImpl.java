package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int HEADER_ROWS_COUNT = 1;
    private static final int EXPECTED_FIELDS_COUNT = 3;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convert(List<String> inputReport) {
        if (inputReport == null || inputReport.isEmpty()) {
            throw new RuntimeException("Input report can't be null or empty");
        }
        List<FruitTransaction> list = new ArrayList<>();
        for (int i = HEADER_ROWS_COUNT; i < inputReport.size(); i++) {
            String line = inputReport.get(i);
            int lineNumber = i + 1;
            String[] linesArray = line.split(",", -1);
            validateFieldsCount(linesArray, lineNumber, line);

            String operationCode = linesArray[OPERATION_INDEX].trim();
            String fruit = linesArray[FRUIT_INDEX].trim();
            int quantity = parseQuantity(linesArray[QUANTITY_INDEX].trim(), lineNumber, line);
            FruitTransaction.Operation operation = parseOperation(operationCode, lineNumber, line);
            list.add(new FruitTransaction(operation, fruit, quantity));
        }
        return list;
    }

    private void validateFieldsCount(String[] linesArray, int lineNumber, String line) {
        if (linesArray.length != EXPECTED_FIELDS_COUNT) {
            throw new RuntimeException("Invalid report line " + lineNumber
                    + ": expected " + EXPECTED_FIELDS_COUNT + " fields but got "
                    + linesArray.length + ". Line: " + line);
        }
    }

    private int parseQuantity(String quantityValue, int lineNumber, String line) {
        try {
            int quantity = Integer.parseInt(quantityValue);
            if (quantity < 0) {
                throw new RuntimeException("Quantity can't be negative");
            }
            return quantity;
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid quantity at report line " + lineNumber
                    + ": '" + quantityValue + "'. Line: " + line, e);
        } catch (RuntimeException e) {
            throw new RuntimeException("Invalid quantity at report line " + lineNumber
                    + ": '" + quantityValue + "'. " + e.getMessage()
                    + ". Line: " + line, e);
        }
    }

    private FruitTransaction.Operation parseOperation(String operationCode, int lineNumber,
                                                      String line) {
        try {
            return FruitTransaction.Operation.getByCode(operationCode);
        } catch (RuntimeException e) {
            throw new RuntimeException("Invalid operation code at report line " + lineNumber
                    + ": '" + operationCode + "'. Line: " + line, e);
        }
    }
}
