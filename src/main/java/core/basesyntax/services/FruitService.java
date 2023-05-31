package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public interface FruitService {
    void store(List<FruitTransaction> transactions,
               Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap);
}
