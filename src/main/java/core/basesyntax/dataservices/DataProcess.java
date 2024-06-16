package core.basesyntax.dataservices;

import core.basesyntax.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface DataProcess {
    Map<String, Integer> process(List<FruitTransaction> transactions);
}
