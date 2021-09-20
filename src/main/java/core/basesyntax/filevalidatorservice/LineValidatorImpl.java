package core.basesyntax.filevalidatorservice;

import core.basesyntax.storeactivities.StoreFunction;
import java.util.Arrays;

public class LineValidatorImpl implements Validator, LineValidator {

    public boolean correctOperation(String operation) {
        return Arrays.stream(StoreFunction.StoreOperations.values())
                .map(Enum::toString)
                .anyMatch(v -> v.equals(operation));
    }

    public boolean correctQuantity(String quantity) {
        return Integer.parseInt(quantity) >= 0;
    }

    public boolean lineValidator(String[] line) {
        return correctOperation(line[OPERATION_INDEX])
                && correctQuantity(line[AMOUNT_INDEX])
                && line[FRUIT_INDEX] != null;
    }
}
