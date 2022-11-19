package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterImpl implements CsvFileWriter {

    @Override
    public void writeReportInFile(String report, String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("File can't be written", e);
        }

    }
}
