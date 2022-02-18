package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterToCsv implements Writer {
    @Override
    public void writeToReport(String report, String toFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFile, true))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file:" + toFile, e);
        }
    }
}
