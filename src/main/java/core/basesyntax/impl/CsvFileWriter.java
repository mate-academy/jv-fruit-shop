package core.basesyntax.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FileWriterService;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvFileWriter implements FileWriterService {
    @Override
    public void writeToFile(File file) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("fruit,quantity\n");
            for (Map.Entry<String, Integer> entry : Storage.STORAGE.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + file, e);
        }
    }
}
