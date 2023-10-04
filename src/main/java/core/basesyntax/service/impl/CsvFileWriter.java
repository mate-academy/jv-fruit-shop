package core.basesyntax.service.impl;

import core.basesyntax.exception.CsvFileException;
import core.basesyntax.service.FileWriter;
import core.basesyntax.util.validator.PathValidator;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvFileWriter implements FileWriter {
    @Override
    public void write(Path destination, String source) {
        PathValidator.validatePath(destination);
        try (BufferedWriter writer = Files.newBufferedWriter(destination)) {
            writer.write(source);
        } catch (IOException e) {
            throw new CsvFileException("Can't write date to csv file: " + destination, e);
        }
    }
}
