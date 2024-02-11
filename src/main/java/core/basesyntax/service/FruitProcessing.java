package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface FruitProcessing {
    Map<String, Integer> fruitProcessing(List<FruitTransaction> fruitTransactions);
}
