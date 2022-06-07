package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParseStatisticService {
    List<FruitTransaction> getFruitTransactionStatistic(List<String> statistic);
}
