package core.basesyntax.services;

import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.Map;

public interface ReportService {
    List<String> createReport(Map<Fruit, Integer> mapQuantityFruit);
}
