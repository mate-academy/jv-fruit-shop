package basesyntax.serviceimpl;

import basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String path) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
            return reader.lines().toList();
        } catch (IOException e) {
            throw new RuntimeException("Can not read file: " + path, e);
        }
    }
}
