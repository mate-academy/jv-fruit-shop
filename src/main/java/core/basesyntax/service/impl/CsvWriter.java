package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter implements Writer {
    @Override
    public void write(List<String> reportData, String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : reportData) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot write output file", e);
        }
    }
}
