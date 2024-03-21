package core.basesyntax.service.impl;

import core.basesyntax.exception.CsvFileException;
import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CvsWriter implements FileWriter {
    @Override
    public void saveDataToFile(Path writePath, List<String> data) {
        try {
            Files.write(writePath, data);
        } catch (IOException e) {
            throw new CsvFileException("Cant write to cvs file " + writePath, e);
        }
    }
}
