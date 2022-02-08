package core.basesyntax.service.validation;

public class DataValidatorImpl implements DataValidator {
    private static final int REQUIRED_INPUT_ROW_PARTS = 3;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int OPERATION_TYPE = 0;
    private static final int FRUITS_AMOUNT = 2;

    @Override
    public boolean validate(String[] inputRowData) {
        if (inputRowData.length != REQUIRED_INPUT_ROW_PARTS) {
            throw new RuntimeException("Invalid input data!");
        }
        int fruitsAmount = Integer.parseInt(inputRowData[FRUITS_AMOUNT]);
        if (fruitsAmount < 0) {
            throw new RuntimeException("Fruits amount can't be less than 0: "
                    + fruitsAmount);
        }
        String fruitName = inputRowData[FRUIT_NAME_INDEX];
        if (fruitName.isEmpty()) {
            throw new RuntimeException("Fruit name can't be empty!");
        }
        String operationType = inputRowData[OPERATION_TYPE];
        if (operationType.isEmpty()) {
            throw new RuntimeException("Operation type can't be empty!");
        }
        return true;
    }
}
