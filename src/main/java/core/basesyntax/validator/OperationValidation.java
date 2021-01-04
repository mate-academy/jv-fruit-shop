package core.basesyntax.validator;

import java.util.List;

public interface OperationValidation {
    boolean isValidOperation(List<String> operationsList, String operation);
}
