package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface OperationService {
    Map<Fruit, Integer> processOperations(List<FruitTransaction> fruitTransactionList);
}
