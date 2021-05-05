package core.basesyntax.service.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileServiceImpl implements FileService {
    @Override
    public List<String> readFile(String data) {
        try {
            return Files.readAllLines(Path.of(data));
        } catch (IOException e) {
            throw new RuntimeException("Can not read from file " + data, e);
        }
    }

    @Override
    public void writeToFile(String fileName, String data) {
        try {
            Files.writeString(Path.of(fileName), data);
        } catch (IOException e) {
            throw new RuntimeException("Can not write data to file " + fileName, e);
        }
    }
}
