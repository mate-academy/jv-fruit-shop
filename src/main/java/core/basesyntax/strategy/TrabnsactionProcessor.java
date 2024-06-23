package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface TrabnsactionProcessor {
    Map<String, Integer> process(List<FruitTransaction> transactions);
}
