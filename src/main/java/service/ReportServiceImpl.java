package service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_CAPTION = "fruit,quantity";

    @Override
    public List<String> makeReport(Map<String, Integer> report) {
        List<String> stringReport = report.entrySet().stream()
                .map(e -> e.getKey() + "," + e.getValue().toString())
                .collect(Collectors.toList());
        stringReport.add(0, REPORT_CAPTION);
        return stringReport;
    }
}
