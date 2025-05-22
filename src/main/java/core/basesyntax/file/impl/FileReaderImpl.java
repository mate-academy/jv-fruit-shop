package core.basesyntax.file.impl;

import core.basesyntax.exception.InvalidDataException;
import core.basesyntax.file.FileReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String path) {
        File file = new File(path);
        try {
            return Files.readAllLines(file.toPath());
        } catch (NoSuchFileException e) {
            throw new InvalidDataException("File not found: " + path);
        } catch (IOException e) {
            throw new InvalidDataException("Error while reading file: " + e.getMessage());
        }
    }
}
