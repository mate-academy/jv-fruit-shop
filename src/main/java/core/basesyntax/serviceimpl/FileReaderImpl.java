package core.basesyntax.serviceimpl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String filePath) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from the file " + filePath);
        }
        return lines;
    }
}
