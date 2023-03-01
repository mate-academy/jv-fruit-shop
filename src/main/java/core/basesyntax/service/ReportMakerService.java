package core.basesyntax.service;

import core.basesyntax.dao.Storage;
import java.util.Map;

public class ReportMakerService {
    private static final String HEADER = "fruit,quantity";
    private static final String CSV_SEPARATOR = ",";

    public String createReport() {
        StringBuilder report = new StringBuilder();
        report.append(HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> fruit : Storage.fruits.entrySet()) {
            report.append(fruit.getKey())
                    .append(CSV_SEPARATOR)
                    .append(fruit.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }

}
