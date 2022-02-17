package core.basesyntax.service;

import java.util.List;
import core.basesyntax.model.Fruit;

public interface FileWriterService {

    void write(String reportFilePath, List<Fruit> fruitsFromStorage);
}
