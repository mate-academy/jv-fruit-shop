package core.basesyntax.converter;

import core.basesyntax.model.FruitTransaction;

import java.util.Objects;

public class StringToFruitValidator {

    public boolean validateInputData(String[] data) {
        return isDataValid(data)
                && isOperatorValid(data)
                && isNameValid(data)
                && isQuantityValid(data);
    }

    private boolean isDataValid(String[] data) {
        return data.length == 3;
    }

    private boolean isOperatorValid(String[] data) {
        try {
            FruitTransaction.Operation.fromCode(data[0]);
            return true;
        } catch (RuntimeException e) {
            throw new RuntimeException("Invalid operator: " + data[0]);
        }
    }

    private boolean isNameValid(String[] data) {
        return !Objects.equals(data[1], "");
    }

    private boolean isQuantityValid(String[] data) {
        return Integer.parseInt(data[2]) > 0;
    }

}
