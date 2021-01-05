package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

public class CsvFileWriter implements FileWriter {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String WORD_SEPARATOR = ",";

    @Override
    public void createReportFile(Map<String, Integer> fruitReport, String path) {
        StringBuilder reportLines = new StringBuilder("fruit,quantity");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(path))) {

            for (Map.Entry<String, Integer> entry : fruitReport.entrySet()) {
                reportLines.append(LINE_SEPARATOR)
                        .append(entry.getKey())
                        .append(WORD_SEPARATOR)
                        .append(entry.getValue());
            }
            bufferedWriter.write(reportLines.toString());
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
