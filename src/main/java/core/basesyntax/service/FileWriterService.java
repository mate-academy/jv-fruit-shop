package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface FileWriterService {
    void write(String reportFilePath, List<Fruit> fruitsFromStorage);
}
