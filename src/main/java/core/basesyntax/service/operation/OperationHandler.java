package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface OperationHandler {
    Map<String, Integer> getOperation(FruitTransaction transaction);
}
