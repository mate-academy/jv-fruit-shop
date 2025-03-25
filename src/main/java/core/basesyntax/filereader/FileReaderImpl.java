package core.basesyntax.filereader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath))
                    .stream()
                    .skip(1)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException("Cant read file " + filePath);
        }
    }
}
