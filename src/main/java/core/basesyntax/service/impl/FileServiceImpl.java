package core.basesyntax.service.impl;

import core.basesyntax.service.FileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileServiceImpl implements FileService {
    @Override
    public List<String> read(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + filePath, e);
        }
    }

    @Override
    public void write(String filePath, String data) {
        try {
            Files.write(Path.of(filePath), data.getBytes(),
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + filePath, e);
        }
    }
}
