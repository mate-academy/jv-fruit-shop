package core.basesyntax.service.fileService;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadFromFile {
    public List<String> read(String file) {
        try {
            return Files.readAllLines(Path.of(file));
        } catch (IOException e) {
            throw new RuntimeException("Can't find file");
        }
    }
}
