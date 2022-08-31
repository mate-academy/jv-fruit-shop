package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface ReportGeneration {
    String generateReport(Map<Fruit, Integer> map);
}
