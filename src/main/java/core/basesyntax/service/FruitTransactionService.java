package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;
import java.util.List;
import java.util.Map;

public interface FruitTransactionService {
    void greatFruitTransaction(List<String> dataFromFile,
                               Map<FruitTransaction.Operation,
                                       OperationHandler> operationHandlerMap);
}
