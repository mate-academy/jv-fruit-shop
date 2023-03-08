package core.basesyntax.service.impl;

import core.basesyntax.service.WriteTheReportToDataBase;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteTheReportToDataBaseImpl implements WriteTheReportToDataBase {
    private static final String REPORT_FILE_NAME = "report.csv";
    private static final String SEPARATOR_TO_WORDS = ",";

    @Override
    public void write(Map<String, Integer> toWrite) {
        if (toWrite == null) {
            throw new RuntimeException("Map what is used to write the file is null!");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(REPORT_FILE_NAME))) {
            writer.write(createTheReportByMap(toWrite));
        } catch (IOException e) {
            throw new RuntimeException("Can't write information to the file" + REPORT_FILE_NAME);
        }
    }

    private String createTheReportByMap(Map<String, Integer> toWrite) {
        StringBuilder toReport = new StringBuilder();
        for (Map.Entry<String, Integer> report : toWrite.entrySet()) {
            toReport.append(report.getKey()).append(SEPARATOR_TO_WORDS)
                    .append(report.getValue()).append(System.lineSeparator());
        }
        return toReport.toString();
    }
}
