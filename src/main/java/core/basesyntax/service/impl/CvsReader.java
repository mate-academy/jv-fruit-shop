package core.basesyntax.service.impl;

import core.basesyntax.exception.CsvFileException;
import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CvsReader implements FileReader {
    @Override
    public List<String> loadDataFromFile(Path readPath) {
        try {
            List<String> lines = Files.readAllLines(readPath);
            return lines;
        } catch (IOException e) {
            throw new CsvFileException("Cant read from cvs file " + readPath, e);
        }
    }
}
