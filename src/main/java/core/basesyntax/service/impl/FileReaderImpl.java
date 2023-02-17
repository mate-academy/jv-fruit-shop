package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> readDataFromFile(String path) {
        try {
            return Files.readAllLines(new File(path).toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + path, e);
        }
    }
}
