package core.basesyntax.service.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> readFile(String filePath) {
        List<String> infoFromInputFile;
        try {
            infoFromInputFile = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file, ", e);
        }
        return infoFromInputFile;
    }
}
