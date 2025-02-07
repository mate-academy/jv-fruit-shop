package core.basesyntax.infrastructure.db;

import core.basesyntax.model.Fruit;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface FileReader {
    void setFruits(Map<String, Fruit> fruitMap) throws IOException;

    List<String> read();
}
