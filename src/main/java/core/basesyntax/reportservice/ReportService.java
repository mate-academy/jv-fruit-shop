package core.basesyntax.reportservice;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface ReportService {
    String createReport(Map<Fruit, Integer> fruitMap);
}
