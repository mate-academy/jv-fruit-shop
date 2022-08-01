package core.basesyntax.fileserviceimpl;

import core.basesyntax.fileservice.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> readFromFile(String filePath) {
        List<String> fromFile;
        try {
            fromFile = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("There is file with such a path: " + filePath);
        }
        return fromFile;
    }
}
