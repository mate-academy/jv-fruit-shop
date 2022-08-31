package core.basesyntax.service;

import core.basesyntax.strategy.FruitOperationHandler;
import java.util.List;
import java.util.Map;

public interface FruitStorageService {
    void process(List<String> data, Map<String, FruitOperationHandler> strategy);
}
