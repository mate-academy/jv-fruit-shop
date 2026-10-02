package service;

import db.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String CSV_HEADER = "fruit,quantity";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String getReport() {
        StringBuilder reportBuilder = new StringBuilder(CSV_HEADER).append(LINE_SEPARATOR);
        for (Map.Entry<String, Integer> entry :
                Storage.fruits.entrySet()) {
            reportBuilder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(LINE_SEPARATOR);
        }
        return reportBuilder.toString();
    }
}
