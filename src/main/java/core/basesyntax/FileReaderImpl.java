package core.basesyntax;

import core.basesyntax.dao.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String fileName) throws IOException {
        try {
            return Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new IOException("Failed to read file: " + fileName, e);
        }
    }
}

