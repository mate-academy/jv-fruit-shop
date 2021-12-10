package core.basesyntax.service.implementation;

import core.basesyntax.service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    private static final int HEADING_INDEX = 0;

    @Override
    public List<String> getRecords(String fileName) {
        List<String> stringsFromFile;
        try {
            stringsFromFile = Files.readAllLines(Path.of(fileName));
            stringsFromFile.remove(HEADING_INDEX);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + fileName, e);
        }
        return stringsFromFile;
    }
}
