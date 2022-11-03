package core.basesyntax.servises.impl;

import core.basesyntax.servises.ReadFromFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadFromFileImpl implements ReadFromFile {
    private static final int REMOVE_INDEX = 0;

    @Override
    public List<String> readFromFile(String path) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(path));
            lines.remove(REMOVE_INDEX);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }
}
