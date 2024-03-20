package core.basesyntax.service.report;

import java.util.List;
import java.util.Map;

public interface ReportGenerator {
    List<String> generate(Map<String, Integer> fruitQuantity);
}
