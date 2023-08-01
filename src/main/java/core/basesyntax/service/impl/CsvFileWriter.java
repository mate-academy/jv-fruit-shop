package core.basesyntax.service.impl;

import core.basesyntax.exception.CsvFileException;
import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvFileWriter implements FileWriter {
    private final Path destiny;

    public CsvFileWriter(Path destiny) {
        this.destiny = destiny;
    }

    @Override
    public void write(String source) {
        try (BufferedWriter writer = Files.newBufferedWriter(destiny)) {
            writer.write(source);
        } catch (IOException e) {
            throw new CsvFileException("Can't write date to csv file: " + destiny, e);
        }
    }
}
