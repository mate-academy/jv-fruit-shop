package service.impl;

import java.util.Map;
import model.Fruit;
import service.ReportService;
import storage.Storage;

public class ReportServiceImpl implements ReportService {
    public static final String HEADER = "fruit,quantity";

    @Override
    public String report() {
        StringBuilder report = new StringBuilder();
        report.append(HEADER).append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> fruit : Storage.dataBase.entrySet()) {
            report.append(fruit.getKey().getTitle())
                    .append(",")
                    .append(fruit.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
