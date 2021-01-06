package core.basesyntax.service.impl;

import core.basesyntax.service.interfaces.DataValidator;
import core.basesyntax.service.operations.Operation;
import java.util.Map;

public class DataValidatorImpl implements DataValidator {
    private final Map<String, Operation> strategyMap;

    public DataValidatorImpl(Map<String, Operation> strategyMap) {
        this.strategyMap = strategyMap;
    }

    @Override
    public void isOperationValid(String[] record) {
        if (strategyMap.get(record[0]) == null) {
            throw new RuntimeException("Operation does not present");
        }
    }

    @Override
    public void isNumberValid(String[] record) {
        Integer integer;
        try {
            integer = Integer.parseInt(record[2]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Input is not number");
        }

        if (integer < 0) {
            throw new RuntimeException("Input must be greater than 0");
        }
    }
}
