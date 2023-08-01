package core.basesyntax.service;

import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.List;
import java.util.Map;

public interface TransactionExecutor {
    void processDate(List<FruitTransaction> data, Map<Operation, OperationHandler> operationHandlerMap);
}
