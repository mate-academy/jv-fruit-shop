package core.basesyntax.infrastructure.db;

import core.basesyntax.model.Fruit;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class FileReaderImpl implements FileReader {
    private static final String FILE_NAME = "src/main/java/operationslist.csv";

    @Override
    public void setFruits(Map<String, Fruit> fruitMap) throws IOException {
        List<String> data = fruitMap.entrySet().stream()
                .map(m -> m.getValue())
                .map(fruit -> fruit.getName() + "," + fruit.getAmount())
                .toList();

        BufferedWriter br = new BufferedWriter(new FileWriter(FILE_NAME));
        for (String str : data) {
            br.write(str + System.lineSeparator());
        }
        br.close();
    }

    @Override
    public List<String> read() {
        try {
            return Files.readAllLines(Path.of(FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file");
        }
    }
}
