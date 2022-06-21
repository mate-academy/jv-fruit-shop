package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import service.ReportGeneratingService;

public class ReportGeneratingServiceImpl implements ReportGeneratingService {
    private static final String FIRST_LINE_OF_REPORT = "fruit,quantity";
    private static final String CSV_SEPARATOR = ",";

    @Override
    public List<String> createReport(Map<String, Integer> db) {
        List<String> report = new ArrayList<>();
        report.add(FIRST_LINE_OF_REPORT);
        for (Map.Entry<String, Integer> entry : db.entrySet()) {
            report.add(entry.getKey() + CSV_SEPARATOR + entry.getValue());
        }
        return report;
    }
}
