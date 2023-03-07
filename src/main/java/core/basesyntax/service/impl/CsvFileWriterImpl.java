package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvFileWriterImpl implements CsvFileWriter {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private final String filePath;

    public CsvFileWriterImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void write(List<String> content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(String.join(LINE_SEPARATOR, content));
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file '" + filePath + '\'');
        }
    }

    @Override
    public String getFileName() {
        return filePath;
    }
}
