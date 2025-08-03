package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileWriterImpl implements FileWriter {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public void write(String report, String filePath) {
        try {
            Files.write(Path.of(filePath), List.of(report.split(LINE_SEPARATOR)));
        } catch (IOException e) {
            throw new RuntimeException("Cannot write file: " + filePath, e);
        }
    }
}
