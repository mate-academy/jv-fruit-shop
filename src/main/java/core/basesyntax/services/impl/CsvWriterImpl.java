package core.basesyntax.services.impl;

import core.basesyntax.services.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class CsvWriterImpl implements FileWriter {
    @Override
    public void write(String fileName, String report) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(fileName))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file " + fileName, e);
        }
    }
}
