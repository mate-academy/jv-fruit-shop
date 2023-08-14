package core.basesyntax.dao;

import core.basesyntax.models.Fruit;
import java.util.Map;

public interface WriteDataToFile {
    void writeDataToFile(Map<Fruit, Integer> dataToUpdateReport);
}
