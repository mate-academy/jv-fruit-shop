package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface FileWriterService {
    void writeReport(List<Fruit> inputList);
}
