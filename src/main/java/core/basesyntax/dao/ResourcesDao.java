package core.basesyntax.dao;

import java.util.List;

public interface ResourcesDao {
    List<String> readFromFile(String fileName);

    void writeToFile(String fileName, List<String> data);
}
