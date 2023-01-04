package core.basesyntax.dao.impl;

import core.basesyntax.dao.FileReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> readData(String code) {
        File file = new File(code);
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + code, e);
        }
    }
}
