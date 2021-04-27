package core.basesyntax.csv.writer;

import core.basesyntax.model.Fruit;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(FileWriter fileWriter, List<Fruit> fruitList) throws IOException {
        for (Fruit fruit : fruitList) {
            fileWriter.write("\n" + fruit.getName() + "," + fruit.getBalance());
        }
    }
}
