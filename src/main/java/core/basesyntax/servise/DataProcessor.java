package core.basesyntax.servise;

import core.basesyntax.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface DataProcessor {
    Map<String, Integer> processTransactions(List<FruitTransaction> transactions);
}
