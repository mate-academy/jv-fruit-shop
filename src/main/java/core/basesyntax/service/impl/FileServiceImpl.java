package core.basesyntax.service.impl;

import core.basesyntax.service.FileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileServiceImpl implements FileService {
    @Override
    public List<String> readFromFile(String filePath) {
        Path path = Path.of(filePath);
        try {
            return  Files.readAllLines(path);
        } catch (IOException exception) {
            throw new RuntimeException("Can`t read the file with the path " + filePath, exception);
        }
    }

    @Override
    public void writeToFile(String filePath, String text) {
        Path path = Path.of(filePath);

        try {
            Files.write(path, text.getBytes());
        } catch (IOException exception) {
            throw new RuntimeException("File could not be found within path "
                    + filePath, exception);
        }
    }
}
