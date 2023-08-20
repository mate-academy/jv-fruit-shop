package core.basesyntax.dao;

import java.util.List;

public interface ReadFromFileDao {
    List<String> readFromFile(String fileName);
}
