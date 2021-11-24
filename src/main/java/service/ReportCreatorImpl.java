package service;

import db.Storage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.Fruit;

public class ReportCreatorImpl implements ReportCreator {
    @Override
    public List<String> createReport() {
        List<String> report = new ArrayList<>();
        report.add("fruit,quantity");
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
            stringBuilder.append(entry.getKey().getName()).append(",").append(entry.getValue());
            report.add(stringBuilder.toString());
            stringBuilder.setLength(0);
        }
        return report;
    }
}
