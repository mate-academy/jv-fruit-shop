package core.basesyntax.csv.writer;

import core.basesyntax.model.Fruit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public interface WriterService {
    void writeToFile(BufferedWriter bufferedWriter, List<Fruit> fruitList) throws IOException;
}
