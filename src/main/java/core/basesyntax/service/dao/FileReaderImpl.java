package core.basesyntax.service.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String fileName) {
        List<String> file;
        try {
            file = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + fileName);
        }
        skipHeader(file);
        return file;
    }

    public void skipHeader(List<String> file) {
        file.remove(0);
    }
}
