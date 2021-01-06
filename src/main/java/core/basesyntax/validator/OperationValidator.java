package core.basesyntax.validator;

import java.util.List;

public interface OperationValidator {
    boolean validationCheck(List<String> operations, String operation);
}
