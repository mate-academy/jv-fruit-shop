package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileServiceImpl implements FileService {
    @Override
    public void write(String data, String fileName) {
        try {
            Files.write(Paths.get(fileName), data.getBytes(),
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + fileName, e);
        }
    }

    @Override
    public List<String> read(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + fileName, e);
        }
    }
}
