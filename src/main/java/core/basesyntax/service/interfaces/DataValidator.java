package core.basesyntax.service.interfaces;

import core.basesyntax.service.operations.Operation;
import java.util.Map;

public interface DataValidator {
    void isOperationValid(Map<String, Operation> strategy, String[] record);

    void isNumberValid(String[] record);
}
