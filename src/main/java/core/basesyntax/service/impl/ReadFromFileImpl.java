package core.basesyntax.service.impl;

import core.basesyntax.service.interfaces.ReadFromFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFileImpl implements ReadFromFile {

    private static final int HEADING_LINE = 0;

    @Override
    public List<String> readFromFile(String path) {
        try {
            List<String> result = new ArrayList<>();
            result = Files.readAllLines(Path.of(path));
            result.remove(HEADING_LINE);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
