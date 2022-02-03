package core.basesyntax.service;

import java.util.Map;
import core.basesyntax.model.Fruit;

public interface DataWriter {
    void writeData(Map<Fruit, Integer> data, String toFileName);
}
