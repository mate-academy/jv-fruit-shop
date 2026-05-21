package service;

import db.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String getReport() {
        StringBuilder reportBuilder = new StringBuilder(HEADER);

        for (Map.Entry<String, Integer> entry : Storage.fruitStorage.entrySet()) {
            reportBuilder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue());
        }

        return reportBuilder.toString();
    }
}
