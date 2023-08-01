package core.basesyntax.service.impl;

import core.basesyntax.service.CsvWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvWriterServiceImpl implements CsvWriterService {
    private static final String TABLE_COLUMN_NAMES = "fruit,quantity";
    private static final String DATA_SEPARATOR = ",";

    @Override
    public void writeToReport(String path, Map<String, Integer> report) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(recData(report));
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file", e);
        }
    }

    private String recData(Map<String, Integer> report) {
        StringBuilder builder = new StringBuilder(TABLE_COLUMN_NAMES);
        for (Map.Entry<String, Integer> entry : report.entrySet()) {
            builder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(DATA_SEPARATOR)
                    .append(entry.getValue());
        }
        return builder.toString();
    }
}
