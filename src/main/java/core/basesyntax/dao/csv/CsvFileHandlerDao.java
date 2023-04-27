package core.basesyntax.dao.csv;

import java.util.List;

public interface CsvFileHandlerDao {
    List<String> readCsv(String filePath);

    void writeToCsv(String filePath, List<String> stringList);
}
