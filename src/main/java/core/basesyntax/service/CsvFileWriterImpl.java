package core.basesyntax.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CsvFileWriterImpl implements CsvFileWriter {

    @Override
    public void writeToFile(String fileName, String report) {
        try {
            Files.write(new File(fileName).toPath(), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to the file " + fileName, e);
        }
    }
}
