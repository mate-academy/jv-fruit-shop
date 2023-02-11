package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface ReportGenerator {
    String generateReport(Map<Fruit, Integer> map);
}
