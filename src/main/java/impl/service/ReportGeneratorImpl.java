package impl.service;

import db.Storage;
import java.util.Map;
import service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String CSV_HEADER = "fruit,quantity";
    private static final String CSV_DELIMITER = ",";

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append(CSV_HEADER).append(System.lineSeparator());
        Map<String, Integer> inventory = Storage.getAll();
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            report.append(entry.getKey())
                    .append(CSV_DELIMITER)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
