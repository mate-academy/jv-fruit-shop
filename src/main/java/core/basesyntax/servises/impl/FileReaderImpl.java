package core.basesyntax.servises.impl;

import core.basesyntax.servises.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private static final int REMOVE_INDEX = 0;

    @Override
    public List<String> readFromFile(String path) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(path));
            lines.remove(REMOVE_INDEX);
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file" + e);
        }
        return lines;
    }
}
