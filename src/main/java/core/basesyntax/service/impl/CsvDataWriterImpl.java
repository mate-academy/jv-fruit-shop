package core.basesyntax.service.impl;

import core.basesyntax.service.DataWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvDataWriterImpl implements DataWriter {
    private static final String PATH = "src/main/resources";

    @Override
    public void writeToFile(List<String> report, String filename) {
        File file = new File(PATH + File.separator + filename);
        try (BufferedWriter bufferedWriter
                     = new BufferedWriter(new FileWriter(file))) {
            for (String line : report) {
                bufferedWriter.write(line + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write in CSV file", e);
        }
    }
}
