package core.basesyntax.validator;

import core.basesyntax.OperationType;
import core.basesyntax.ValidatorException;

public class ValidatorImpl implements Validator<String> {
    private static final int OPERATION_TYPE = 0;
    private static final int FRUITS_AMOUNT = 2;

    @Override
    public boolean validate(String record) throws ValidatorException {
        String[] recordToColumns = record.split(",");
        if (recordToColumns.length != 3) {
            throw new ValidatorException("Record isn`t full! Incorrect input in record: "
                    + record);
        }
        if (parseToInteger(recordToColumns[FRUITS_AMOUNT]) < 0) {
            throw new ValidatorException("Incorrect operation value: "
                    + recordToColumns[FRUITS_AMOUNT]
                    + " for operation - "
                    + OperationType.getEnumValue(recordToColumns[OPERATION_TYPE]));
        }
        return true;
    }

    private Integer parseToInteger(String fruitAmount) throws ValidatorException {
        try {
            return Integer.parseInt(fruitAmount);
        } catch (NumberFormatException e) {
            throw new ValidatorException("Incorrect \"quantity\" value type: "
                    + fruitAmount);
        }
    }
}
