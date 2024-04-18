package core.basesyntax.dao;

import java.util.List;

public interface FileDataReader {
    List<String> readFromFile(String nameOfFile);
}
