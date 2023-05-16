package core.basesyntax.data_process;

import core.basesyntax.model.FruitTransaction;

import java.util.List;
import java.util.Map;

public interface FruitDataProcess {
    Map<String, Integer> processFruitsData(List<FruitTransaction> fruitTransactionList);
}
