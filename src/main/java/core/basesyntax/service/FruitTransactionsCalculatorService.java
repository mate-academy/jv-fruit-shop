package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.operation.OperationHandler;
import java.util.Map;

public interface FruitTransactionsCalculatorService {
    Map<String, Integer> calculateMap(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap);
}
