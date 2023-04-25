package core.basesyntax.dao.csv;

import java.util.List;

public interface CsvDao {
    List<String> readCsv();

    void writeToCsv(List<String> stringList);
}
