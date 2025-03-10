package core.basesyntax.db;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String data, String fileName) {
        Path reportFile = Paths.get(fileName);
        try {
            Files.write(reportFile, data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write the file: "
                    + fileName
                    + ", see description below.",e);
        }
    }
}
