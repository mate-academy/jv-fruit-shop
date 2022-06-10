package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CsvFileWriteServiceImpl implements FileWriterService {
    @Override
    public void writeToFile(String filePath) {
        try (var writer = Files.newBufferedWriter(Paths.get(filePath))) {
            writer.write("fruit,quantity");
            for (Fruit fruit : Storage.fruits) {
                writer.write(System.lineSeparator() + fruit.getName() + "," + fruit.getQuantity());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + filePath, e);
        }
    }
}
