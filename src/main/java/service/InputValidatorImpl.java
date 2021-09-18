package service;

import java.util.List;

public class InputValidatorImpl implements InputValidator {

    private static final int DATA_START_FROM_LINE = 1;
    private static final int OPERATION_TYPE_COLULMN_INDEX = 0;
    private static final int FRUIT_TYPE_COLUMN_INDEX = 1;
    private static final int FRUIT_QUANTITY_COLUMN_INDEX = 2;
    private static final int REQ_COLUMNS_FOR_REPORT = 3;

    @Override
    public void validateInput(List<String> listFromFile) {
        for (int i = DATA_START_FROM_LINE; i < listFromFile.size(); i++) {
            String[] inputColumn = listFromFile.get(i).split(",");

            String operationType = inputColumn[OPERATION_TYPE_COLULMN_INDEX];
            String fruitType = inputColumn[FRUIT_TYPE_COLUMN_INDEX];
            int fruitAmount = Integer.parseInt(inputColumn[FRUIT_QUANTITY_COLUMN_INDEX]);

            if (inputColumn.length != REQ_COLUMNS_FOR_REPORT
                    || fruitType.isBlank() || operationType.isBlank()) {
                throw new RuntimeException("Missing data in row: "
                        + (i + 1) + ". Row: " + listFromFile.get(i));
            }

            if (fruitAmount < 0) {
                throw new RuntimeException("Fruit count can not be negative. Row #"
                        + (i + 1) + ". Row: " + listFromFile.get(i));
            }
        }
    }
}
