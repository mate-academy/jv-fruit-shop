package core.basesyntax.impl;

import core.basesyntax.ReadingCsvFile;
import core.basesyntax.service.CantWorkWithThisFileException;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadingCsvFileImpl implements ReadingCsvFile {
    @Override
    public List<String> reading(String FileName) {
        try {
            return Files.readAllLines(Path.of(FileName));
        } catch (IOException e) {
            throw new CantWorkWithThisFileException("We don't know how to read this",e);
        }
    }
}
