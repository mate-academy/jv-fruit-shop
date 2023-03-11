package service.impl;

import db.Storage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.Fruit;
import service.ReportCreator;

public class ReportCreatorImpl implements ReportCreator {
    private static final String TEXT_TITLE = "fruit,quantity";

    @Override
    public List<String> createReport() {
        List<String> report = new ArrayList<>();
        report.add(TEXT_TITLE);
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
            stringBuilder.append(entry.getKey().getName()).append(",").append(entry.getValue());
            report.add(stringBuilder.toString());
            stringBuilder.setLength(0);
        }
        return report;
    }
}
