package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.Map;

public interface ReportService {
    List<String> makeReport(Map<Fruit, Integer> storage);
}
