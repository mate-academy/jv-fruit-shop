package core.basesyntax.reader;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface FileReaderService {
    List<Fruit> readFile(String path);
}
