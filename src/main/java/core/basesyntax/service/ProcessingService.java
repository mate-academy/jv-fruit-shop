package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.Map;

public interface ProcessingService {
    Map<String, Integer> processStatistics(List<Fruit> fruits);
}
