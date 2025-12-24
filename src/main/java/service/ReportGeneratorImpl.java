package service;

import db.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String COMMA = ",";
    private static final String SEPARATE_BY = "fruit,quantity";

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder(SEPARATE_BY + System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.fruitStorage.entrySet()) {
            report.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
