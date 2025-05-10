package core.basesyntax.fileservice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> readFile(String nameOfFile) {
        try {
            return Files.readAllLines(Path.of(nameOfFile));
        } catch (IOException e) {
            throw new RuntimeException("File is not found" + nameOfFile, e);
        }
    }
}
