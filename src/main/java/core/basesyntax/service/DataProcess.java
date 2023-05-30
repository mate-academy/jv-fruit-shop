package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public interface DataProcess {
    void addDataToDB(List<FruitTransaction> fruitTransactions, OperationStrategy operationStrategy);
}
