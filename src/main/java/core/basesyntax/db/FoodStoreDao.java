package core.basesyntax.db;

import java.nio.file.Path;
import java.util.List;

public interface FoodStoreDao {
    List<String> read(Path fileName);
}
