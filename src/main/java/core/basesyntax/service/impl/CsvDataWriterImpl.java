package core.basesyntax.service.impl;

import core.basesyntax.service.DataWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvDataWriterImpl implements DataWriter {
    private static final String PATH = "src/main/resources";
    private String report;

    public CsvDataWriterImpl(String report) {
        this.report = report;
    }

    @Override
    public void writeToFile(String filename) {
        File file = new File(PATH + File.separator + filename);
        try (BufferedWriter bufferedWriter
                     = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write in CSV file", e);
        }
    }
}
