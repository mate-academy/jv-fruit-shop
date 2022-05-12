package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterImpl implements Writer {
    @Override
    public void write(String report, String fileName) {
        if (report.length() == 0) {
            throw new RuntimeException("Empty report file");
        }
        try (BufferedWriter csvWriter = new BufferedWriter(new FileWriter(fileName))) {
            csvWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + fileName);
        }
    }
}
