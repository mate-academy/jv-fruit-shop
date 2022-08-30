package core.service;

import core.strategy.FruitStrategy;
import java.util.List;
import java.util.Map;

public interface ProcessingService {
    void process(Map<String, FruitStrategy> strategyMap, List<String> stringList);
}
