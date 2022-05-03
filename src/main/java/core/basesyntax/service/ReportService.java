package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ReportService {
    List<String> makeReport(Set<Map.Entry<Fruit, Integer>> data);
}
