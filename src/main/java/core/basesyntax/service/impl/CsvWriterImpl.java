package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvWriterImpl implements FileWriter {
    @Override
    public void writeCsv(List<String> report, Path toPath) {
        try {
            Files.write(toPath, report);
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong during writing"
                    + " process to file: " + toPath);
        }
    }
}
