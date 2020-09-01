package core.basesyntax.interfaces;

import core.basesyntax.model.Fruit;
import java.io.IOException;
import java.util.List;

public interface FileWriter {
    void writeNewFile(List<Fruit> fruit) throws IOException;
}
