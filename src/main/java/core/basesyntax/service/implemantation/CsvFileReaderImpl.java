package core.basesyntax.service.implemantation;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReaderImpl implements FileReader {
    @Override
    public List<String> readData(String fileNameToRead) {
        try {
            return Files.readAllLines(Path.of(fileNameToRead));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + fileNameToRead, e);
        }
    }
}
