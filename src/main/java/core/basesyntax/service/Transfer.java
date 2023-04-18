package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public interface Transfer {
    String report(Map<String,Integer> fruitData);

    Fruit splitLine(String line);

    void generateInfo(String[] info, OperationStrategy operationStrategy);
}
