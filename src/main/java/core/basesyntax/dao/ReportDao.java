package core.basesyntax.dao;

import java.util.Map;

public interface ReportDao {

    void writeReport(Map<String, Integer> endOfDayFruitQuantities, String filePath);
}
