package core.basesyntax.file.impl;

import core.basesyntax.exception.InvalidDataException;
import core.basesyntax.file.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String path) {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(path))) {
            return reader.lines().toList();
        } catch (NoSuchFileException e) {
            throw new InvalidDataException("File not found: " + path);
        } catch (IOException e) {
            throw new InvalidDataException("Error while reading file: " + e.getMessage());
        }
    }
}
