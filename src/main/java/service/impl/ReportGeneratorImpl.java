package service.impl;

import db.Storage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import service.ReportCreator;

public class ReportGeneratorImpl implements ReportCreator {
    private static final String HEADER = "fruit, quantity";
    private static final String DELIMITOR = ",";

    @Override
    public List<String> createReport(Map<String, Integer> data) {
        List<String> report = new ArrayList<>();
        report.add(HEADER);
        for (Map.Entry<String, Integer> entry : Storage.fruitsStorage.entrySet()) {
            report.add(entry.getKey() + DELIMITOR + entry.getValue());
        }
        return report;
    }
}
