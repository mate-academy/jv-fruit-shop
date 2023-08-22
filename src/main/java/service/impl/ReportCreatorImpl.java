package service.impl;

import db.Storage;
import java.util.Map;
import service.ReportCreator;

public class ReportCreatorImpl implements ReportCreator {
    private static final String BASE_MESSAGE = "fruit,quantity";

    @Override
    public String createReport(Storage storage) {
        StringBuilder report = new StringBuilder(BASE_MESSAGE);
        Map<String, Integer> map = storage.getFruitBox();
        for (String key : map.keySet()) {
            report.append(System.lineSeparator())
                    .append(key)
                    .append(",")
                    .append(map.get(key));
        }
        return report.toString();
    }
}
