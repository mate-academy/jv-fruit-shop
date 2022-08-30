package core.basesyntax.servise;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface ReportGenerator {
    String generateReport(Map<Fruit, Integer> storage);
}
