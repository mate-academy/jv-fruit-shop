package service.impl;

import db.Storage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.Fruit;
import service.ReportService;

public class ReportServiceImpl implements ReportService<String> {
    private static final String FIRST_LINE_IN_REPORT = "fruit,quantity";

    @Override
    public List<String> createReport() {
        List<String> report = new ArrayList<>();
        report.add(FIRST_LINE_IN_REPORT);
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
            stringBuilder.append(entry.getKey().getName()).append(",").append(entry.getValue());
            report.add(stringBuilder.toString());
            stringBuilder.setLength(0);
        }
        return report;
    }
}
