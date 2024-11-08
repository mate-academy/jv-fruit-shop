package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int FIRST_ROW = 0;
    private static final String DELIMITER = ",";
    private static final int EXPECTED_ROW_LENGTH = 3;
    private static final int OPERATION_TYPE = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY_OF_FRUITS = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> dataToConvert) {
        ValidFirstLinePredicate validFirstLine = new ValidFirstLinePredicate();
        String firstRow = dataToConvert.get(FIRST_ROW);

        if (validFirstLine.test(firstRow)) {
            dataToConvert.remove(FIRST_ROW);
        }
        List<FruitTransaction> convertedDataFromList = new ArrayList<>();

        for (String row : dataToConvert) {
            try {
                String[] rowData = row.split(DELIMITER);

                if (rowData.length != EXPECTED_ROW_LENGTH) {
                    throw new IllegalArgumentException("Incorrect row format: " + row);
                }
                FruitTransaction.Operation operationFromCode = getOperationFromCode(
                        rowData[OPERATION_TYPE].trim()
                );

                FruitTransaction fruitTransaction = new FruitTransaction(
                        operationFromCode,
                        rowData[FRUIT_NAME].trim(),
                        Integer.parseInt(rowData[QUANTITY_OF_FRUITS].trim())
                );
                convertedDataFromList.add(fruitTransaction);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                throw new RuntimeException("Can't convert data from file: " + dataToConvert + e);
            }
        }
        return convertedDataFromList;
    }

    private FruitTransaction.Operation getOperationFromCode(String code) {
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getCode().equalsIgnoreCase(code.trim())) {
                return operation;
            }
        }
        throw new IllegalArgumentException("Unknown operation code: " + code);
    }
}
