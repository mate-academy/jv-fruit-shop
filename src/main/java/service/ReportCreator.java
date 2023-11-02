package service;

import db.Storage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportCreator {
    private static final String HEADER = "fruit,quantity";

    public List<String> create() {
        List<String> report = new ArrayList<>();

        report.add(HEADER);

        for (Map.Entry<String, Integer> entry : Storage.getFruitsAndAmount().entrySet()) {
            report.add(entry.getKey() + "," + entry.getValue());
        }

        return report;
    }
}
