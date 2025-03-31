package service.impl;

import db.Storage;
import java.util.Map;
import service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";
    private final Map<String, Integer> fruitList;

    public ReportGeneratorImpl(Map<String, Integer> fruitList) {
        this.fruitList = fruitList;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        Map<String, Integer> fruitList = Storage.getAllFruit();
        report.append(HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : fruitList.entrySet()) {
            report.append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());

        }
        return report.toString();
    }
}
