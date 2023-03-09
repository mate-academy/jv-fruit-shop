package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface ReportGenerator {
    String reportFromStorage(Map<Fruit, Integer> inputMap);
}
