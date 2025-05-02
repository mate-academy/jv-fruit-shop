package core.basesyntax.dao;

import java.io.File;
import java.util.List;

public interface FruitDao {
    String readFromFile(File file);

    void writeToFile(File file, List<String> data);
}
