package core.basesyntax.model.dto;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface WriteToFile {
    void writeToFile(Map<Fruit, Integer> map);
}
