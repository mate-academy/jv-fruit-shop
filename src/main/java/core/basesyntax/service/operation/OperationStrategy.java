package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;

import java.util.HashMap;
import java.util.Map;

public interface OperationStrategy {
    //Map<FruitTransaction.Operation, OperationHandler> operationStrategy = new HashMap<>();
    OperationHandler get(FruitTransaction.Operation operation);
}
