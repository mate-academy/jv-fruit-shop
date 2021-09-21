package core.basesyntax.service.validator;

public class RecordValidatorImpl implements RecordValidator {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_AMOUNT_INDEX = 2;
    private static final int FRUIT_RECORD_FIELDS_NUMBER = 3;

    @Override
    public void checkRecord(String[] recordData) {
        if (recordData.length != FRUIT_RECORD_FIELDS_NUMBER) {
            throw new RuntimeException("Wrong input data! Record must have all Fruit fields");
        }
        int fruitAmount = Integer.parseInt(recordData[FRUIT_AMOUNT_INDEX]);
        if (fruitAmount < 0) {
            throw new RuntimeException("Fruit amount cannot be fewer 0: "
                    + fruitAmount);
        }
        String fruitName = recordData[FRUIT_NAME_INDEX];
        if (fruitName.isEmpty()) {
            throw new RuntimeException("Fruit name cannot be empty!");
        }
        String operationType = recordData[OPERATION_TYPE_INDEX];
        if (operationType.isEmpty()) {
            throw new RuntimeException("Operation type cannot be empty!");
        }
    }
}
