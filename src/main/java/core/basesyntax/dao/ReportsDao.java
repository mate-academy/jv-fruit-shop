package core.basesyntax.dao;

import java.util.List;
import java.util.Map;

public interface ReportsDao {
    List<String> getRawRecords(String sourceFilename);

    void saveReport(Map<String, Integer> transactionsMap, String reportFilename);
}
