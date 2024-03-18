package core.basesyntax.strategy.reportprovider;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface ReportProvider {
    Map<String, Integer> processData(List<FruitTransaction> transactions);
}
