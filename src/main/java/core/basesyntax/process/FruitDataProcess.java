package core.basesyntax.process;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface FruitDataProcess {
    Map<String, Integer> processFruitData(List<FruitTransaction> fruitTransactionList);
}
