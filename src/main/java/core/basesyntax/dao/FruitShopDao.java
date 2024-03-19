package core.basesyntax.dao;

import java.nio.file.Path;
import java.util.List;

public interface FruitShopDao {
    List<String> loadDataFromFile(Path path);

    void saveDataToFile(Path path, List<String> data);
}
