package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriterImpl implements  CsvWriter {
    public void generateCsvReport(String pathname, String report) {
        File file = new File(pathname);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file \"" + file + "\"", e);
        }
    }
}
