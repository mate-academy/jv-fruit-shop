package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReaderImpl implements CsvFileReader {
    public static final int FIRST_LINE_FROM_FILE = 0;

    @Override
    public List<String> readFile(String filePath) {
        List<String> stringsFromFile;
        try {
            stringsFromFile = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + filePath, e);
        }
        stringsFromFile.remove(FIRST_LINE_FROM_FILE);
        return stringsFromFile;
    }
}
