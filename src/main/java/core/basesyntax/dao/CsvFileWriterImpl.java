package core.basesyntax.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CsvFileWriterImpl implements CsvFileWriter {

    @Override
    public void write(String data, String filePath) {
        try {
            Files.write(Paths.get(filePath),data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Failed to write data to file: " + filePath, e);
        }
    }
}
