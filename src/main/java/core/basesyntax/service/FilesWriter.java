package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface FilesWriter {
    void write(Map<Fruit, Integer> report, String fileName);
}
