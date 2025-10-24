package service.impl;

import interfaces.FileReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> read(String path) {
        if (path != null) {
            try {
                return Files.readAllLines(Paths.get(path));
            } catch (IOException e) {
                throw new UncheckedIOException("Can't read file" + path, e);
            }
        } else {
            throw new IllegalArgumentException("Path can't be null");
        }

    }
}
