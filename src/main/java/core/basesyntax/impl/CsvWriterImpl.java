package core.basesyntax.impl;

import core.basesyntax.service.CsvFileWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriterImpl implements CsvFileWriter {
    @Override
    public void writeFile(String fileToWrite, String report) {
        try (BufferedWriter bufferedWriter =
                new BufferedWriter(new FileWriter(fileToWrite))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file "
            + fileToWrite, e);
        }
    }
}
