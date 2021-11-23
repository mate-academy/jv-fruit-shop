package core.basesyntax.services.impl;

import core.basesyntax.services.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String filePath) {
        List<String> records;
        try {
            records = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can not read data from the file or file is wrong");
        }
        return records;
    }
}
