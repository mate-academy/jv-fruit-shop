package core.basesyntax.service.impl;

import core.basesyntax.service.ReportFileWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriter implements ReportFileWriter {
    @Override
    public void write(String data, String toFileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFileName))) {
            bufferedWriter.write(data);
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException("Cant write data to file: " + toFileName, e);
        }
    }
}
