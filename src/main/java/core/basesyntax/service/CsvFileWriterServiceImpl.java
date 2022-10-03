package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {
    @Override
    public void writeToFile(String info, Path path) {
        try {
            Files.write(path, info.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write info to file");
        }
    }
}
