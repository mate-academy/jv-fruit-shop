package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import service.GenerateReport;

public class GenerateReportImpl implements GenerateReport {
    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public List<String> generateReport(Map<String,Integer> storage) {
        List<String> result = new ArrayList<>();
        result.add(HEADER);
        for (Map.Entry<String,Integer> entry : storage.entrySet()) {
            result.add(entry.getKey() + SEPARATOR + entry.getValue());
        }
        return result;
    }
}
