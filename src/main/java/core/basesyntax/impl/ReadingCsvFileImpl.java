package core.basesyntax.impl;

import core.basesyntax.service.CantWorkWithThisFileException;
import core.basesyntax.service.ReadingCsvFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadingCsvFileImpl implements ReadingCsvFile {
    @Override
    public List<String> reading(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new CantWorkWithThisFileException("We don't know how to read this",e);
        }
    }
}
