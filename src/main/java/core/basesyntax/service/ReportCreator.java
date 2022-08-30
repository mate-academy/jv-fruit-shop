package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public interface ReportCreator {
    String generateReport(Set<Map.Entry<Fruit, Integer>> results);
}
