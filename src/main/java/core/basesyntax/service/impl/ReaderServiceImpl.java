package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReaderImpl implements Reader {

    @Override
    public List<String> get(String filePath) {
        File fileToPath = new File(filePath);
        try {
            return Files.readAllLines(fileToPath.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + e);
        }
    }
}
