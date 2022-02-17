package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface FileWriter {
    void writeData(Map<Fruit, Integer> data, String toFileName);
}
