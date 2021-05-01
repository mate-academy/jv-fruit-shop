package core.basesyntax.service;

import core.basesyntax.service.interfaces.FileReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReaderImplForCsv implements FileReader {
    private static final int SKIP_FIRST_LINE = 0;

    @Override
    public List<String> readAllLinesFromFile(String fileName) {
        File fileFrom = new File(fileName);
        List<String> csvValues;
        try {
            csvValues = Files.readAllLines(fileFrom.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + fileName, e);
        }
        csvValues.remove(SKIP_FIRST_LINE);
        return csvValues;
    }
}
