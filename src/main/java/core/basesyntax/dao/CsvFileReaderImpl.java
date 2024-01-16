package core.basesyntax.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileReaderImpl implements FileReader {
    @Override
    public List<String> get(File fromFileName) {
        List<String> textFromFile;
        try {
            textFromFile = Files.readAllLines(fromFileName.toPath())
                    .stream()
                    .map(String::trim)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + fromFileName);
        }
        return textFromFile;
    }
}
