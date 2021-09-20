package core.basesyntax.dataservice;

import core.basesyntax.model.FruitType;
import core.basesyntax.model.OperationType;

public class Validator {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    public boolean isValidData(String[] dataForValidation) {
        try {
            OperationType.valueOf(dataForValidation[OPERATION_INDEX]);
            FruitType.valueOf(dataForValidation[FRUIT_INDEX]);
            Integer.parseInt(dataForValidation[AMOUNT_INDEX]);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("File has incorrect data! "
                    + "Can't create report! Check file and try again! " + e);
        }
        return Integer.parseInt(dataForValidation[AMOUNT_INDEX]) >= OPERATION_INDEX;
    }
}
