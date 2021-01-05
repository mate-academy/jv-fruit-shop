package core.basesyntax.servise.impl;

import core.basesyntax.servise.FilesReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FilesReaderImpl implements FilesReader {
    @Override
    public List<String> readData(String fileName) {
        List<String> list;
        try {
            list = Files.readAllLines(Path.of(fileName));
            list.remove(0);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return list;
    }
}
