package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public interface FruitService {
    void getOperationByFruit(List<FruitTransaction> fruitTransactionList,
                             OperationStrategy strategy);
}
