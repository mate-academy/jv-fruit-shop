package core.basesyntax.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileService {

    public List<String> getLinesFromFile(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Cant read data from file" + fileName, e);
        }
    }

    public void writeTextToFile(String fileName, String text) {
        try {
            Files.write(Path.of(fileName), text.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("Cant write data to file" + text, e);
        }
    }
}
