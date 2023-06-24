package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationStrategy;
import java.util.List;

public interface FruitService {
    void processFruit(List<FruitTransaction> fruitTransactionList,
                      OperationStrategy operationStrategy);
}
