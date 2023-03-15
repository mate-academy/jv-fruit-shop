package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;

import java.util.HashMap;
import java.util.Map;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
