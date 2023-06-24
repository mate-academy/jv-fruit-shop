package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvFileWriter implements FileWriterService {
    @Override
    public void writeToFile(File file, List<String> data) {
        try (FileWriter writer = new FileWriter(file)) {
            for (String value : data) {
                writer.write(value);
            }
            System.out.println("The report was successfully written to file " + file);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + file, e);
        }
    }
}
