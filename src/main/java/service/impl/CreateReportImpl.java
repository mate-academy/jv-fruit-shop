package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import service.CreateReport;

public class CreateReportImpl implements CreateReport {
    @Override
    public List<String> createReport(Map<String, Integer> fruitsAtStorageMap) {
        List<String> report = new ArrayList<>();
        report.add("fruits,quantity");
        fruitsAtStorageMap.forEach((key, value) -> report.add(System.lineSeparator() + key + "," + value));
        return report;
    }
}
