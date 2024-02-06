package core.basesyntax.report;

import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.Map;

public interface ReportGenerator {
    List<String> generateReport(Map<Fruit, Integer> storage);
}
