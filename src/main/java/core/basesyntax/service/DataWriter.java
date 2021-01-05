package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface DataWriter {
    void write(Map<Fruit, Integer> storage, String destinationFile);
}
