package core.basesyntax.service;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handler.OperationHandler;
import java.util.List;
import java.util.Map;

public interface ProcessDataService {
    void processData(List<Transaction> list,
                     Map<Operation, OperationHandler> operationsMap,
                     OperationStrategy strategy);
}
