package core.basesyntax.service.validation;

public class DataValidatorImpl implements DataValidator {
    private static final int REQUIRED_INPUT_ROW_PARTS = 3;

    @Override
    public boolean validate(String[] inputRowData) {
        if (inputRowData.length != REQUIRED_INPUT_ROW_PARTS) {
            throw new RuntimeException("Invalid input data!");
        }
        int fruitsAmount = Integer.parseInt(inputRowData[2]);
        if (fruitsAmount < 0) {
            throw new RuntimeException("Fruits amount can't be less than 0: "
                    + fruitsAmount);
        }
        String fruitName = inputRowData[1];
        if (fruitName.isEmpty()) {
            throw new RuntimeException("Fruit name can't be empty!");
        }
        String operationType = inputRowData[0];
        if (operationType.isEmpty()) {
            throw new RuntimeException("Operation type can't be empty!");
        }
        return false;
    }
}
