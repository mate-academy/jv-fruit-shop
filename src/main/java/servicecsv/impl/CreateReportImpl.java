package servicecsv.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import servicecsv.CreateReport;

public class CreateReportImpl implements CreateReport {
    @Override
    public List<String> createReport(Map<String, Integer> fruitsAtStorageMap) {
        List<String> report = new ArrayList<>();
        report.add("fruits,quantity");
        fruitsAtStorageMap.forEach((key, value) -> report.add(key + "," + value));
        return report;
    }
}
