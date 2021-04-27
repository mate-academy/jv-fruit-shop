package core.basesyntax.csv.writer;

import core.basesyntax.model.Fruit;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public interface WriterService {
    void writeToFile(FileWriter fileWriter, List<Fruit> fruitList) throws IOException;
}
