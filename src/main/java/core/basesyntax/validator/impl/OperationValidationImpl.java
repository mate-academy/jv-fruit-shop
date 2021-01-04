package core.basesyntax.validator.impl;

import core.basesyntax.validator.OperationValidation;
import java.util.List;

public class OperationValidationImpl implements OperationValidation {
    @Override
    public boolean isValidOperation(List<String> operationsList, String operation) {
        if (!operationsList.contains(operation)) {
            throw new RuntimeException(String.format("'%s' is wrong operation.", operation));
        }
        return true;
    }
}
