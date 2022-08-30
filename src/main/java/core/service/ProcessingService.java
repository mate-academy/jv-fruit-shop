package core.service;

import core.strategy.FruitStrategy;
import java.util.List;

public interface ProcessingService {
    void process(FruitStrategy fruitStrategy, List<String> stringList);
}
