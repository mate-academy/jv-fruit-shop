package core.basesyntax.process;

import core.basesyntax.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface ProcessData {
    Map<String, Integer> processingData(List<FruitTransaction> transactions);
}
