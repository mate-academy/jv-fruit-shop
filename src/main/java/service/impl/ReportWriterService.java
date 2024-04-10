package service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import service.FileWriterService;

public class ReportWriterService implements FileWriterService {
    private static final String HEADER_LINE = "fruit,quantity";
    private static final String Separator = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String PATH_TO_REPORT_FILE = "src/main/java/resources/Report.csv";

    @Override
    public void writeToFile(Map<String, Integer> fruitsBalanceReport) {
        StringBuilder builder = new StringBuilder(HEADER_LINE);
        for (Map.Entry<String, Integer> entry : fruitsBalanceReport.entrySet()) {
            builder.append(LINE_SEPARATOR)
                    .append(entry.getKey())
                    .append(Separator)
                    .append(entry.getValue());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH_TO_REPORT_FILE))) {
            writer.write(builder.toString());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + PATH_TO_REPORT_FILE, e);
        }
    }
}
