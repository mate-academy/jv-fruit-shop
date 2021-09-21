package core.basesyntax.service.validator;

import core.basesyntax.model.OperationType;

public class ValidatorImpl implements Validator {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public boolean isValidData(String[] dataForValidation) {
        if (dataForValidation.length != 3) {
            throw new RuntimeException("File has incorrect data type! "
                    + "Can't create report! Check file and try again!");
        }
        try {
            OperationType.getOperation(dataForValidation[OPERATION_INDEX]);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("File has incorrect operation type! "
                    + "Can't create report! Check file and try again! " + e);
        }
        try {
            Integer.parseInt(dataForValidation[AMOUNT_INDEX]);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("File has incorrect amount type! "
                    + "Can't create report! Check file and try again! " + e);
        }
        if (!dataForValidation[FRUIT_INDEX].matches("[a-zA-Z]+")) {
            throw new RuntimeException("File has incorrect fruit type! "
                    + "Can't create report! Check file and try again! ");
        }
        if (Integer.parseInt(dataForValidation[AMOUNT_INDEX]) < 0) {
            throw new RuntimeException("Amount can't be less than zero");
        }
        return true;
    }
}
