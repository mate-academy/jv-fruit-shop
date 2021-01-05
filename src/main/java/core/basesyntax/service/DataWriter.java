package core.basesyntax.service;

import core.basesyntax.model.Fruits;
import java.util.Map;

public interface DataWriter {
    void write(Map<Fruits, Integer> storage, String destinationFile);
}
