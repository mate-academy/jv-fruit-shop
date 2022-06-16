package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationProcessingStrategy;
import java.util.List;

public interface DataHandlerService {
    void handleData(List<FruitTransaction> fruitTransactions,
                    OperationProcessingStrategy operationProcessingStrategy);
}
