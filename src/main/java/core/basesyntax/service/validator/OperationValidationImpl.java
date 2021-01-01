package core.basesyntax.service.validator;

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
