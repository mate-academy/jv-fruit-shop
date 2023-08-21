package core.basesyntax.dao;

import java.util.List;

public interface FileDao {
    List<String> readFromFile(String fileName);

    void writeToFile(String fileName, String reportString);
}
