package core.basesyntax.servise;

import java.util.List;
import java.util.Map;

public interface ReportGenerator {
    List<String> generateReport(Map<String, Integer> fruitStore);
}
