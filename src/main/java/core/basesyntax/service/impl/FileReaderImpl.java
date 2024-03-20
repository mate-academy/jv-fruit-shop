package core.basesyntax.service.impl;

import core.basesyntax.exception.CsvParseException;
import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> readFrom(String fileName) {
        try {
            return Files.lines(Path.of(fileName)).toList();
        } catch (IOException | NumberFormatException e) {
            throw new CsvParseException("Unexpected parsed error in " + fileName);
        }
    }
}
