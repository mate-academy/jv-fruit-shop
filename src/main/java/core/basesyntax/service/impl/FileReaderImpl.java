package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String file) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(file));
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path", e);
        }
        return lines;
    }
}
