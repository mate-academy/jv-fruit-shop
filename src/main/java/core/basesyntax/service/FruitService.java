package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import java.util.List;
import java.util.Map;

public interface FruitService {
    void processActivities(List<TransactionDto> incomeAlgorithm);

    Map<Fruit, Integer> getReport();
}
