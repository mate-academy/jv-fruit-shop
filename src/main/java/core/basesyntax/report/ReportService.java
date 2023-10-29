package core.basesyntax.report;

import java.io.IOException;
import java.util.Map;

public interface ReportService {
    String generateReport(Map<String, Integer> fruitInventory);

    void createReport(Map<String, Integer> fruitInventory) throws IOException;
}
