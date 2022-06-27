package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvReaderImpl implements FileReader {
    @Override
    public List<String> readFile(Path filePath) {
        try {
            return Files.readAllLines(filePath, Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException("Something wrong went with the file: "
                    + filePath);
        }
    }
}
