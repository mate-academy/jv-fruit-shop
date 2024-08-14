package impl;

import db.Storage;
import java.util.Map;
import service.ReportCreator;

public class ReportCreatorImpl implements ReportCreator {
    private static final String SEPARATOR = ",";
    private static final String HEADER = "fruit,quantity";

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder(HEADER);
        report.append(System.lineSeparator());
        for (Map.Entry<String, Integer> fruits : Storage.fruits.entrySet()) {
            report.append(fruits.getKey())
                    .append(SEPARATOR)
                    .append(fruits.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
