package core.basesyntax.service.report;

import java.util.List;
import java.util.Map;

public interface ReportService {
    List<String> report(Map<String, Integer> fruitStorage);
}
