package core.basesyntax.service;

import core.basesyntax.database.Operation;
import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface FruitshopService {
    void processData(List<FruitTransaction> fruitTransactionList,
                     Map<Operation, OperationHandler> operationHandlerMap);
}
