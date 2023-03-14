package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FileWriterService;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvFileWriter implements FileWriterService {
    private static final String HEADER = "fruit,quantity";

    @Override
    public void writeToFile(File file) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(HEADER);
            for (Map.Entry<String, Integer> entry : Storage.STORAGE.entrySet()) {
                writer.write("\n" + entry.getKey() + "," + entry.getValue());
            }
            System.out.println("The report was successfully written to file " + file);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + file, e);
        }
    }
}
