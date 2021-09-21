package core.basesyntax.service.validator;

import core.basesyntax.model.FruitType;
import core.basesyntax.model.OperationType;

public class ValidatorImpl implements Validator {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public boolean isValidData(String[] dataForValidation) {
        try {
            OperationType.valueOf(dataForValidation[OPERATION_INDEX]);
            FruitType.valueOf(dataForValidation[FRUIT_INDEX]);
            Integer.parseInt(dataForValidation[AMOUNT_INDEX]);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("File has incorrect data! "
                    + "Can't create report! Check file and try again! " + e);
        }
        if (Integer.parseInt(dataForValidation[AMOUNT_INDEX]) < 0) {
            throw new RuntimeException("Amount can't be less than zero");
        }
        return true;
    }
}
