package service;

import java.util.List;

public class InputValidatorImpl implements InputValidator {

    private static final int DATA_START_FROM_LINE = 1;
    private static final int OPERATION_TYPE_COLULMN_INDEX = 0;
    private static final int FRUIT_TYPE_COLUMN_INDEX = 1;
    private static final int FRUIT_QUANTITY_COLUMN_INDEX = 2;
    private static final int REQ_COLUMNS_FOR_REPORT = 3;
    private static final String DELIMITER = ",";

    @Override
    public boolean validateInput(List<String> listFromFile) {
        for (int i = DATA_START_FROM_LINE; i < listFromFile.size(); i++) {
            String[] fruitLineArray = listFromFile.get(i).split(DELIMITER);

            checkColumnAmount(fruitLineArray);

            String operationType = fruitLineArray[OPERATION_TYPE_COLULMN_INDEX];
            String fruitType = fruitLineArray[FRUIT_TYPE_COLUMN_INDEX];
            int fruitAmount = Integer.parseInt(fruitLineArray[FRUIT_QUANTITY_COLUMN_INDEX]);

            columnIsNotEmpty(operationType);
            columnIsNotEmpty(fruitType);
            checkFruitAmount(fruitAmount);
        }
        return true;
    }

    private void checkColumnAmount(String[] inputArray) {
        if (inputArray.length != REQ_COLUMNS_FOR_REPORT) {
            throw new IllegalArgumentException("Wrong data format");
        }
    }

    private void columnIsNotEmpty(String column) {
        if (column.isBlank()) {
            throw new IllegalArgumentException("Missing data in one of the columns");
        }
    }

    private void checkFruitAmount(int fruitAmount) {
        if (fruitAmount < 0) {
            throw new IllegalArgumentException("Fruit amount can not be negative");
        }
    }

}
