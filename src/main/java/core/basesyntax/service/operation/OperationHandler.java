package core.basesyntax.service.operation;

import core.basesyntax.model.Operation;
import java.util.Map;

public interface OperationHandler {
    int getAmount(Operation operation, Map<String, Integer> fruitsStorage);
}
