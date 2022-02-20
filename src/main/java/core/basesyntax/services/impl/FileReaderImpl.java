package core.basesyntax.services.impl;

import core.basesyntax.services.FileReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String filePath) {
        File file = new File(filePath);
        List<String> data;
        try {
            data = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Unable to open file", e);
        }
        return data;
    }
}
