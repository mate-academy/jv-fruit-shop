package core.basesyntax.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileWriterImpl implements FruitFileWriter {

    @Override
    public void write(List<String> report, String fileName) {
        try {
            Files.write(Path.of(fileName),report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write into the file by path: " + fileName, e);
        }
    }
}
