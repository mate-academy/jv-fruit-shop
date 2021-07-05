package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> readLines(String fileName) {
        List<String> strings;
        try {
            strings = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read from file " + fileName, e);
        }
        return strings;
    }
}
