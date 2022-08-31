package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public interface ReportService {
    String create(Set<Map.Entry<Fruit, Integer>> fruitsDataMap);
}
