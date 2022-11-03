package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface OperationStrategy {
    OperationHandler getOperationType(String key);

    void operationTypeList(Map<FruitTransaction.Operation, OperationHandler> strategies);
}
