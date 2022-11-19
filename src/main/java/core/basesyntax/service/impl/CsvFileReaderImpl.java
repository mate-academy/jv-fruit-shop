package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReaderImpl implements CsvFileReader {

    @Override
    public List<String> readInputFile(String fileName) {
        List<String> dateInputFile;
        try {
            dateInputFile = Files.readAllLines(Path.of(fileName));
            dateInputFile.remove(0);
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + Path.of(fileName), e);
        }
        return dateInputFile;
    }
}
