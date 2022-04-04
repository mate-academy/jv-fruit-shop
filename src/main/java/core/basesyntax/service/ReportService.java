package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public interface ReportService {
    StringBuilder makeReport(Set<Map.Entry<Fruit, Integer>> entrySet);
}
