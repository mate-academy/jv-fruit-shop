package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> read(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new IOException("Can't read/find " + fileName + " file", e);
        }
    }
}
