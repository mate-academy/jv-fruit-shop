package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface ProcessDataService {
    Map<String, Integer> processing(List<FruitTransaction> operations);
}
