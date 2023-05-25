package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public interface FruitService {
    void makeOperationByFruit(List<FruitTransaction> fruitTransactionList,
                              OperationStrategy strategy);
}
