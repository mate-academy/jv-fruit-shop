package core.basesyntax.dao;

import java.util.List;

public interface FruitDao {
    List<String> getRecords(String inputFileName);

    void writeReport(String targetFileName, List<String> report);
}
