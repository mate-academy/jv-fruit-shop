package core.basesyntax.infratructure.db;

import core.basesyntax.model.Fruit;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface FruitsDao {
    void setFruits(Map<String, Fruit> fruitMap) throws IOException;

    List<String> getFruits() throws IOException;
}
