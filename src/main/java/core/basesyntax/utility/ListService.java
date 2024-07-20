package core.basesyntax.utility;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface ListService {
    Map<String, Integer> getComputedMap(List<FruitTransaction> fruitTransactionList);
}
