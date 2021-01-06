package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public class CsvFileWriter implements FileWriter {

    @Override
    public void writeReportToFile(Map<String, Long> report, String pathToFile) {
        try (Writer writer = new java.io.FileWriter(pathToFile)) {
            writer.append("fruit,amount").append(System.lineSeparator());
            for (Map.Entry<String, Long> entry : report.entrySet()) {
                writer.append(entry.getKey())
                        .append(',')
                        .append(entry.getValue().toString())
                        .append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file " + pathToFile, e);
        }
    }
}
