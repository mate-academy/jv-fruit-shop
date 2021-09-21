package core.basesyntax.dao;

import java.util.List;

public interface FruitRecordsDao {

    List<String> readDataFromFile(String fileName);

    void writeDataToFile(String filename, String data);
}
