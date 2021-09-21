package core.basesyntax.dao;

import java.util.List;
import java.util.Map;

public interface ActivitiesDao {
    List<String> getActivities(String pathToFile);

    void writeReportInFile(String pathToFile, Map<String, Integer> report);
}
