package core.basesyntax;

import java.util.List;
import java.util.Map;

public interface ReportGenerator {
    List<String> generateReport(Map<String, Integer> fruitBalance);
}
