package core.basesyntax.service.impl;

import core.basesyntax.service.DataWriterService;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class DataWriterServiceImpl implements DataWriterService {
    private static final String CSV_HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public void writeReportToFile(Map<String, Integer> report, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(CSV_HEADER + System.lineSeparator());

            for (Map.Entry<String, Integer> entry : report.entrySet()) {
                String line = entry.getKey() + SEPARATOR + entry.getValue();
                writer.write(line + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file " + fileName, e);
        }
    }
}
