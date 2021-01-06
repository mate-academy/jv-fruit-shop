package core.basesyntax.validator;

import java.util.List;

public class OperationValidatorImpl implements OperationValidator {
    @Override
    public boolean validationCheck(List<String> operations, String operation) {
        if (!operations.contains(operation)) {
            throw new RuntimeException("Wrong operation!");
        }
        return true;
    }
}
