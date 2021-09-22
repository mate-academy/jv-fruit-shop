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
        isValidOperation(dataForValidation[OPERATION_INDEX]);
        isValidFruit(dataForValidation[FRUIT_INDEX]);
        isValidAmount(dataForValidation[AMOUNT_INDEX]);
        return true;
    }

    private boolean isValidOperation(String operation) {
        try {
            OperationType.getOperation(operation);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("File has incorrect operation type! "
                    + "Can't create report! Check file and try again! " + e);
        }
        return true;
    }

    private boolean isValidFruit(String fruit) {
        if (!fruit.matches("[a-zA-Z]+")) {
            throw new RuntimeException("File has incorrect fruit type! "
                    + "Can't create report! Check file and try again! ");
        }
        return true;
    }

    private boolean isValidAmount(String amount) {
        try {
            Integer.parseInt(amount);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("File has incorrect amount type! "
                    + "Can't create report! Check file and try again! " + e);
        }
        if (Integer.parseInt(amount) < 0) {
            throw new RuntimeException("Amount can't be less than zero");
        }
        return true;
    }

}
