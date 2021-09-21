package core.basesyntax.dao;

import java.util.List;

public interface FileReaderDao {
    List<String> getDataFromFile(String fileName);
}
